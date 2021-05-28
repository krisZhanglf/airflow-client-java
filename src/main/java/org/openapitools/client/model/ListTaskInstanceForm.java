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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * ListTaskInstanceForm
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-28T08:16:16.047364Z[Etc/UTC]")
public class ListTaskInstanceForm {
  public static final String SERIALIZED_NAME_DAG_IDS = "dag_ids";
  @SerializedName(SERIALIZED_NAME_DAG_IDS)
  private List<String> dagIds = null;

  public static final String SERIALIZED_NAME_EXECUTION_DATE_GTE = "execution_date_gte";
  @SerializedName(SERIALIZED_NAME_EXECUTION_DATE_GTE)
  private OffsetDateTime executionDateGte;

  public static final String SERIALIZED_NAME_EXECUTION_DATE_LTE = "execution_date_lte";
  @SerializedName(SERIALIZED_NAME_EXECUTION_DATE_LTE)
  private OffsetDateTime executionDateLte;

  public static final String SERIALIZED_NAME_START_DATE_GTE = "start_date_gte";
  @SerializedName(SERIALIZED_NAME_START_DATE_GTE)
  private OffsetDateTime startDateGte;

  public static final String SERIALIZED_NAME_START_DATE_LTE = "start_date_lte";
  @SerializedName(SERIALIZED_NAME_START_DATE_LTE)
  private OffsetDateTime startDateLte;

  public static final String SERIALIZED_NAME_END_DATE_GTE = "end_date_gte";
  @SerializedName(SERIALIZED_NAME_END_DATE_GTE)
  private OffsetDateTime endDateGte;

  public static final String SERIALIZED_NAME_END_DATE_LTE = "end_date_lte";
  @SerializedName(SERIALIZED_NAME_END_DATE_LTE)
  private OffsetDateTime endDateLte;

  public static final String SERIALIZED_NAME_DURATION_GTE = "duration_gte";
  @SerializedName(SERIALIZED_NAME_DURATION_GTE)
  private BigDecimal durationGte;

  public static final String SERIALIZED_NAME_DURATION_LTE = "duration_lte";
  @SerializedName(SERIALIZED_NAME_DURATION_LTE)
  private BigDecimal durationLte;

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private List<String> state = null;

  public static final String SERIALIZED_NAME_POOL = "pool";
  @SerializedName(SERIALIZED_NAME_POOL)
  private List<String> pool = null;

  public static final String SERIALIZED_NAME_QUEUE = "queue";
  @SerializedName(SERIALIZED_NAME_QUEUE)
  private List<String> queue = null;


  public ListTaskInstanceForm dagIds(List<String> dagIds) {
    
    this.dagIds = dagIds;
    return this;
  }

  public ListTaskInstanceForm addDagIdsItem(String dagIdsItem) {
    if (this.dagIds == null) {
      this.dagIds = new ArrayList<String>();
    }
    this.dagIds.add(dagIdsItem);
    return this;
  }

   /**
   * Return objects with specific DAG IDs. The value can be repeated to retrieve multiple matching values (OR condition).
   * @return dagIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Return objects with specific DAG IDs. The value can be repeated to retrieve multiple matching values (OR condition).")

  public List<String> getDagIds() {
    return dagIds;
  }


  public void setDagIds(List<String> dagIds) {
    this.dagIds = dagIds;
  }


  public ListTaskInstanceForm executionDateGte(OffsetDateTime executionDateGte) {
    
    this.executionDateGte = executionDateGte;
    return this;
  }

   /**
   * Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period. 
   * @return executionDateGte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period. ")

  public OffsetDateTime getExecutionDateGte() {
    return executionDateGte;
  }


  public void setExecutionDateGte(OffsetDateTime executionDateGte) {
    this.executionDateGte = executionDateGte;
  }


  public ListTaskInstanceForm executionDateLte(OffsetDateTime executionDateLte) {
    
    this.executionDateLte = executionDateLte;
    return this;
  }

   /**
   * Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. 
   * @return executionDateLte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. ")

  public OffsetDateTime getExecutionDateLte() {
    return executionDateLte;
  }


  public void setExecutionDateLte(OffsetDateTime executionDateLte) {
    this.executionDateLte = executionDateLte;
  }


  public ListTaskInstanceForm startDateGte(OffsetDateTime startDateGte) {
    
    this.startDateGte = startDateGte;
    return this;
  }

   /**
   * Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
   * @return startDateGte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. ")

  public OffsetDateTime getStartDateGte() {
    return startDateGte;
  }


  public void setStartDateGte(OffsetDateTime startDateGte) {
    this.startDateGte = startDateGte;
  }


  public ListTaskInstanceForm startDateLte(OffsetDateTime startDateLte) {
    
    this.startDateLte = startDateLte;
    return this;
  }

   /**
   * Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
   * @return startDateLte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. ")

  public OffsetDateTime getStartDateLte() {
    return startDateLte;
  }


  public void setStartDateLte(OffsetDateTime startDateLte) {
    this.startDateLte = startDateLte;
  }


  public ListTaskInstanceForm endDateGte(OffsetDateTime endDateGte) {
    
    this.endDateGte = endDateGte;
    return this;
  }

   /**
   * Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
   * @return endDateGte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. ")

  public OffsetDateTime getEndDateGte() {
    return endDateGte;
  }


  public void setEndDateGte(OffsetDateTime endDateGte) {
    this.endDateGte = endDateGte;
  }


  public ListTaskInstanceForm endDateLte(OffsetDateTime endDateLte) {
    
    this.endDateLte = endDateLte;
    return this;
  }

   /**
   * Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
   * @return endDateLte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. ")

  public OffsetDateTime getEndDateLte() {
    return endDateLte;
  }


  public void setEndDateLte(OffsetDateTime endDateLte) {
    this.endDateLte = endDateLte;
  }


  public ListTaskInstanceForm durationGte(BigDecimal durationGte) {
    
    this.durationGte = durationGte;
    return this;
  }

   /**
   * Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period. 
   * @return durationGte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period. ")

  public BigDecimal getDurationGte() {
    return durationGte;
  }


  public void setDurationGte(BigDecimal durationGte) {
    this.durationGte = durationGte;
  }


  public ListTaskInstanceForm durationLte(BigDecimal durationLte) {
    
    this.durationLte = durationLte;
    return this;
  }

   /**
   * Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range. 
   * @return durationLte
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range. ")

  public BigDecimal getDurationLte() {
    return durationLte;
  }


  public void setDurationLte(BigDecimal durationLte) {
    this.durationLte = durationLte;
  }


  public ListTaskInstanceForm state(List<String> state) {
    
    this.state = state;
    return this;
  }

  public ListTaskInstanceForm addStateItem(String stateItem) {
    if (this.state == null) {
      this.state = new ArrayList<String>();
    }
    this.state.add(stateItem);
    return this;
  }

   /**
   * The value can be repeated to retrieve multiple matching values (OR condition).
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The value can be repeated to retrieve multiple matching values (OR condition).")

  public List<String> getState() {
    return state;
  }


  public void setState(List<String> state) {
    this.state = state;
  }


  public ListTaskInstanceForm pool(List<String> pool) {
    
    this.pool = pool;
    return this;
  }

  public ListTaskInstanceForm addPoolItem(String poolItem) {
    if (this.pool == null) {
      this.pool = new ArrayList<String>();
    }
    this.pool.add(poolItem);
    return this;
  }

   /**
   * The value can be repeated to retrieve multiple matching values (OR condition).
   * @return pool
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The value can be repeated to retrieve multiple matching values (OR condition).")

  public List<String> getPool() {
    return pool;
  }


  public void setPool(List<String> pool) {
    this.pool = pool;
  }


  public ListTaskInstanceForm queue(List<String> queue) {
    
    this.queue = queue;
    return this;
  }

  public ListTaskInstanceForm addQueueItem(String queueItem) {
    if (this.queue == null) {
      this.queue = new ArrayList<String>();
    }
    this.queue.add(queueItem);
    return this;
  }

   /**
   * The value can be repeated to retrieve multiple matching values (OR condition).
   * @return queue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The value can be repeated to retrieve multiple matching values (OR condition).")

  public List<String> getQueue() {
    return queue;
  }


  public void setQueue(List<String> queue) {
    this.queue = queue;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTaskInstanceForm listTaskInstanceForm = (ListTaskInstanceForm) o;
    return Objects.equals(this.dagIds, listTaskInstanceForm.dagIds) &&
        Objects.equals(this.executionDateGte, listTaskInstanceForm.executionDateGte) &&
        Objects.equals(this.executionDateLte, listTaskInstanceForm.executionDateLte) &&
        Objects.equals(this.startDateGte, listTaskInstanceForm.startDateGte) &&
        Objects.equals(this.startDateLte, listTaskInstanceForm.startDateLte) &&
        Objects.equals(this.endDateGte, listTaskInstanceForm.endDateGte) &&
        Objects.equals(this.endDateLte, listTaskInstanceForm.endDateLte) &&
        Objects.equals(this.durationGte, listTaskInstanceForm.durationGte) &&
        Objects.equals(this.durationLte, listTaskInstanceForm.durationLte) &&
        Objects.equals(this.state, listTaskInstanceForm.state) &&
        Objects.equals(this.pool, listTaskInstanceForm.pool) &&
        Objects.equals(this.queue, listTaskInstanceForm.queue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dagIds, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTaskInstanceForm {\n");
    sb.append("    dagIds: ").append(toIndentedString(dagIds)).append("\n");
    sb.append("    executionDateGte: ").append(toIndentedString(executionDateGte)).append("\n");
    sb.append("    executionDateLte: ").append(toIndentedString(executionDateLte)).append("\n");
    sb.append("    startDateGte: ").append(toIndentedString(startDateGte)).append("\n");
    sb.append("    startDateLte: ").append(toIndentedString(startDateLte)).append("\n");
    sb.append("    endDateGte: ").append(toIndentedString(endDateGte)).append("\n");
    sb.append("    endDateLte: ").append(toIndentedString(endDateLte)).append("\n");
    sb.append("    durationGte: ").append(toIndentedString(durationGte)).append("\n");
    sb.append("    durationLte: ").append(toIndentedString(durationLte)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
    sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
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

