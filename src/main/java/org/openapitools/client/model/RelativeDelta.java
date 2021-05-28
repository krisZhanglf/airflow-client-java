/*
 * Airflow API (Stable)
 * # Overview  To facilitate management, Apache Airflow supports a range of REST API endpoints across its objects. This section provides an overview of the API design, methods, and supported use cases.  Most of the endpoints accept `JSON` as input and return `JSON` responses. This means that you must usually add the following headers to your request: ``` Content-type: application/json Accept: application/json ```  ## Resources  The term `resource` refers to a single type of object in the Airflow metadata. An API is broken up by its endpoint's corresponding resource. The name of a resource is typically plural and expressed in camelCase. Example: `dagRuns`.  Resource names are used as part of endpoint URLs, as well as in API parameters and responses.  ## CRUD Operations  The platform supports **C**reate, **R**ead, **U**pdate, and **D**elete operations on most resources. You can review the standards for these operations and their standard parameters below.  Some endpoints have special behavior as exceptions.  ### Create  To create a resource, you typically submit an HTTP `POST` request with the resource's required metadata in the request body. The response returns a `201 Created` response code upon success with the resource's metadata, including its internal `id`, in the response body.  ### Read  The HTTP `GET` request can be used to read a resource or to list a number of resources.  A resource's `id` can be submitted in the request parameters to read a specific resource. The response usually returns a `200 OK` response code upon success, with the resource's metadata in the response body.  If a `GET` request does not include a specific resource `id`, it is treated as a list request. The response usually returns a `200 OK` response code upon success, with an object containing a list of resources' metadata in the response body.  When reading resources, some common query parameters are usually available. e.g.: ``` v1/connections?limit=25&offset=25 ```  |Query Parameter|Type|Description| |---------------|----|-----------| |limit|integer|Maximum number of objects to fetch. Usually 25 by default| |offset|integer|Offset after which to start returning objects. For use with limit query parameter.|  ### Update  Updating a resource requires the resource `id`, and is typically done using an HTTP `PATCH` request, with the fields to modify in the request body. The response usually returns a `200 OK` response code upon success, with information about the modified resource in the response body.  ### Delete  Deleting a resource requires the resource `id` and is typically executing via an HTTP `DELETE` request. The response usually returns a `204 No Content` response code upon success.  ## Conventions  - Resource names are plural and expressed in camelCase. - Names are consistent between URL parameter name and field name.  - Field names are in snake_case. ```json {     \"name\": \"string\",     \"slots\": 0,     \"occupied_slots\": 0,     \"used_slots\": 0,     \"queued_slots\": 0,     \"open_slots\": 0 } ```  ### Update Mask  Update mask is available as a query parameter in patch endpoints. It is used to notify the API which fields you want to update. Using `update_mask` makes it easier to update objects by helping the server know which fields to update in an object instead of updating all fields. The update request ignores any fields that aren't specified in the field mask, leaving them with their current values.  Example: ```   resource = request.get('/resource/my-id').json()   resource['my_field'] = 'new-value'   request.patch('/resource/my-id?update_mask=my_field', data=json.dumps(resource)) ```  ## Versioning and Endpoint Lifecycle  - API versioning is not synchronized to specific releases of the Apache Airflow. - APIs are designed to be backward compatible. - Any changes to the API will first go through a deprecation phase.  # Summary of Changes  | Airflow version | Description | |-|-| | v2.0 | Initial release | | v2.0.2    | Added /plugins endpoint | | v2.1 | New providers endpoint |  # Trying the API  You can use a third party client, such as [curl](https://curl.haxx.se/), [HTTPie](https://httpie.org/), [Postman](https://www.postman.com/) or [the Insomnia rest client](https://insomnia.rest/) to test the Apache Airflow API.  Note that you will need to pass credentials data.  For e.g., here is how to pause a DAG with [curl](https://curl.haxx.se/), when basic authorization is used: ```bash curl -X POST 'https://example.com/api/v1/dags/{dag_id}?update_mask=is_paused' \\ -H 'Content-Type: application/json' \\ --user \"username:password\" \\ -d '{     \"is_paused\": true }' ```  Using a graphical tool such as [Postman](https://www.postman.com/) or [Insomnia](https://insomnia.rest/), it is possible to import the API specifications directly:  1. Download the API specification by clicking the **Download** button at top of this document 2. Import the JSON specification in the graphical tool of your choice.   - In *Postman*, you can click the **import** button at the top   - With *Insomnia*, you can just drag-and-drop the file on the UI  Note that with *Postman*, you can also generate code snippets by selecting a request and clicking on the **Code** button.  ## Enabling CORS  [Cross-origin resource sharing (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) is a browser security feature that restricts HTTP requests that are initiated from scripts running in the browser.  For details on enabling/configuring CORS, see [Enabling CORS](https://airflow.apache.org/docs/apache-airflow/stable/security/api.html).  # Authentication  To be able to meet the requirements of many organizations, Airflow supports many authentication methods, and it is even possible to add your own method.  If you want to check which auth backend is currently set, you can use `airflow config get-value api auth_backend` command as in the example below. ```bash $ airflow config get-value api auth_backend airflow.api.auth.backend.basic_auth ``` The default is to deny all requests.  For details on configuring the authentication, see [API Authorization](https://airflow.apache.org/docs/apache-airflow/stable/security/api.html).  # Errors  We follow the error response format proposed in [RFC 7807](https://tools.ietf.org/html/rfc7807) also known as Problem Details for HTTP APIs. As with our normal API responses, your client must be prepared to gracefully handle additional members of the response.  ## Unauthenticated  This indicates that the request has not been applied because it lacks valid authentication credentials for the target resource. Please check that you have valid credentials.  ## PermissionDenied  This response means that the server understood the request but refuses to authorize it because it lacks sufficient rights to the resource. It happens when you do not have the necessary permission to execute the action you performed. You need to get the appropriate permissions in other to resolve this error.  ## BadRequest  This response means that the server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing). To resolve this, please ensure that your syntax is correct.  ## NotFound  This client error response indicates that the server cannot find the requested resource.  ## MethodNotAllowed  Indicates that the request method is known by the server but is not supported by the target resource.  ## NotAcceptable  The target resource does not have a current representation that would be acceptable to the user agent, according to the proactive negotiation header fields received in the request, and the server is unwilling to supply a default representation.  ## AlreadyExists  The request could not be completed due to a conflict with the current state of the target resource, meaning that the resource already exists  ## Unknown  This means that the server encountered an unexpected condition that prevented it from fulfilling the request. 
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: dev@airflow.apache.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Relative delta
 */
@ApiModel(description = "Relative delta")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-28T08:16:16.047364Z[Etc/UTC]")
public class RelativeDelta {
  public static final String SERIALIZED_NAME_TYPE = "__type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_YEARS = "years";
  @SerializedName(SERIALIZED_NAME_YEARS)
  private Integer years;

  public static final String SERIALIZED_NAME_MONTHS = "months";
  @SerializedName(SERIALIZED_NAME_MONTHS)
  private Integer months;

  public static final String SERIALIZED_NAME_DAYS = "days";
  @SerializedName(SERIALIZED_NAME_DAYS)
  private Integer days;

  public static final String SERIALIZED_NAME_LEAPDAYS = "leapdays";
  @SerializedName(SERIALIZED_NAME_LEAPDAYS)
  private Integer leapdays;

  public static final String SERIALIZED_NAME_HOURS = "hours";
  @SerializedName(SERIALIZED_NAME_HOURS)
  private Integer hours;

  public static final String SERIALIZED_NAME_MINUTES = "minutes";
  @SerializedName(SERIALIZED_NAME_MINUTES)
  private Integer minutes;

  public static final String SERIALIZED_NAME_SECONDS = "seconds";
  @SerializedName(SERIALIZED_NAME_SECONDS)
  private Integer seconds;

  public static final String SERIALIZED_NAME_MICROSECONDS = "microseconds";
  @SerializedName(SERIALIZED_NAME_MICROSECONDS)
  private Integer microseconds;

  public static final String SERIALIZED_NAME_YEAR = "year";
  @SerializedName(SERIALIZED_NAME_YEAR)
  private Integer year;

  public static final String SERIALIZED_NAME_MONTH = "month";
  @SerializedName(SERIALIZED_NAME_MONTH)
  private Integer month;

  public static final String SERIALIZED_NAME_DAY = "day";
  @SerializedName(SERIALIZED_NAME_DAY)
  private Integer day;

  public static final String SERIALIZED_NAME_HOUR = "hour";
  @SerializedName(SERIALIZED_NAME_HOUR)
  private Integer hour;

  public static final String SERIALIZED_NAME_MINUTE = "minute";
  @SerializedName(SERIALIZED_NAME_MINUTE)
  private Integer minute;

  public static final String SERIALIZED_NAME_SECOND = "second";
  @SerializedName(SERIALIZED_NAME_SECOND)
  private Integer second;

  public static final String SERIALIZED_NAME_MICROSECOND = "microsecond";
  @SerializedName(SERIALIZED_NAME_MICROSECOND)
  private Integer microsecond;


  public RelativeDelta type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  public RelativeDelta years(Integer years) {
    
    this.years = years;
    return this;
  }

   /**
   * Get years
   * @return years
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getYears() {
    return years;
  }


  public void setYears(Integer years) {
    this.years = years;
  }


  public RelativeDelta months(Integer months) {
    
    this.months = months;
    return this;
  }

   /**
   * Get months
   * @return months
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getMonths() {
    return months;
  }


  public void setMonths(Integer months) {
    this.months = months;
  }


  public RelativeDelta days(Integer days) {
    
    this.days = days;
    return this;
  }

   /**
   * Get days
   * @return days
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getDays() {
    return days;
  }


  public void setDays(Integer days) {
    this.days = days;
  }


  public RelativeDelta leapdays(Integer leapdays) {
    
    this.leapdays = leapdays;
    return this;
  }

   /**
   * Get leapdays
   * @return leapdays
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getLeapdays() {
    return leapdays;
  }


  public void setLeapdays(Integer leapdays) {
    this.leapdays = leapdays;
  }


  public RelativeDelta hours(Integer hours) {
    
    this.hours = hours;
    return this;
  }

   /**
   * Get hours
   * @return hours
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getHours() {
    return hours;
  }


  public void setHours(Integer hours) {
    this.hours = hours;
  }


  public RelativeDelta minutes(Integer minutes) {
    
    this.minutes = minutes;
    return this;
  }

   /**
   * Get minutes
   * @return minutes
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getMinutes() {
    return minutes;
  }


  public void setMinutes(Integer minutes) {
    this.minutes = minutes;
  }


  public RelativeDelta seconds(Integer seconds) {
    
    this.seconds = seconds;
    return this;
  }

   /**
   * Get seconds
   * @return seconds
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getSeconds() {
    return seconds;
  }


  public void setSeconds(Integer seconds) {
    this.seconds = seconds;
  }


  public RelativeDelta microseconds(Integer microseconds) {
    
    this.microseconds = microseconds;
    return this;
  }

   /**
   * Get microseconds
   * @return microseconds
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getMicroseconds() {
    return microseconds;
  }


  public void setMicroseconds(Integer microseconds) {
    this.microseconds = microseconds;
  }


  public RelativeDelta year(Integer year) {
    
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getYear() {
    return year;
  }


  public void setYear(Integer year) {
    this.year = year;
  }


  public RelativeDelta month(Integer month) {
    
    this.month = month;
    return this;
  }

   /**
   * Get month
   * @return month
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getMonth() {
    return month;
  }


  public void setMonth(Integer month) {
    this.month = month;
  }


  public RelativeDelta day(Integer day) {
    
    this.day = day;
    return this;
  }

   /**
   * Get day
   * @return day
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getDay() {
    return day;
  }


  public void setDay(Integer day) {
    this.day = day;
  }


  public RelativeDelta hour(Integer hour) {
    
    this.hour = hour;
    return this;
  }

   /**
   * Get hour
   * @return hour
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getHour() {
    return hour;
  }


  public void setHour(Integer hour) {
    this.hour = hour;
  }


  public RelativeDelta minute(Integer minute) {
    
    this.minute = minute;
    return this;
  }

   /**
   * Get minute
   * @return minute
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getMinute() {
    return minute;
  }


  public void setMinute(Integer minute) {
    this.minute = minute;
  }


  public RelativeDelta second(Integer second) {
    
    this.second = second;
    return this;
  }

   /**
   * Get second
   * @return second
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getSecond() {
    return second;
  }


  public void setSecond(Integer second) {
    this.second = second;
  }


  public RelativeDelta microsecond(Integer microsecond) {
    
    this.microsecond = microsecond;
    return this;
  }

   /**
   * Get microsecond
   * @return microsecond
  **/
  @ApiModelProperty(required = true, value = "")

  public Integer getMicrosecond() {
    return microsecond;
  }


  public void setMicrosecond(Integer microsecond) {
    this.microsecond = microsecond;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelativeDelta relativeDelta = (RelativeDelta) o;
    return Objects.equals(this.type, relativeDelta.type) &&
        Objects.equals(this.years, relativeDelta.years) &&
        Objects.equals(this.months, relativeDelta.months) &&
        Objects.equals(this.days, relativeDelta.days) &&
        Objects.equals(this.leapdays, relativeDelta.leapdays) &&
        Objects.equals(this.hours, relativeDelta.hours) &&
        Objects.equals(this.minutes, relativeDelta.minutes) &&
        Objects.equals(this.seconds, relativeDelta.seconds) &&
        Objects.equals(this.microseconds, relativeDelta.microseconds) &&
        Objects.equals(this.year, relativeDelta.year) &&
        Objects.equals(this.month, relativeDelta.month) &&
        Objects.equals(this.day, relativeDelta.day) &&
        Objects.equals(this.hour, relativeDelta.hour) &&
        Objects.equals(this.minute, relativeDelta.minute) &&
        Objects.equals(this.second, relativeDelta.second) &&
        Objects.equals(this.microsecond, relativeDelta.microsecond);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, years, months, days, leapdays, hours, minutes, seconds, microseconds, year, month, day, hour, minute, second, microsecond);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelativeDelta {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    years: ").append(toIndentedString(years)).append("\n");
    sb.append("    months: ").append(toIndentedString(months)).append("\n");
    sb.append("    days: ").append(toIndentedString(days)).append("\n");
    sb.append("    leapdays: ").append(toIndentedString(leapdays)).append("\n");
    sb.append("    hours: ").append(toIndentedString(hours)).append("\n");
    sb.append("    minutes: ").append(toIndentedString(minutes)).append("\n");
    sb.append("    seconds: ").append(toIndentedString(seconds)).append("\n");
    sb.append("    microseconds: ").append(toIndentedString(microseconds)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
    sb.append("    minute: ").append(toIndentedString(minute)).append("\n");
    sb.append("    second: ").append(toIndentedString(second)).append("\n");
    sb.append("    microsecond: ").append(toIndentedString(microsecond)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

