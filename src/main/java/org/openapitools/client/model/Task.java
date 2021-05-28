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
import org.openapitools.client.model.ClassReference;
import org.openapitools.client.model.DAG;
import org.openapitools.client.model.TaskExtraLinks;
import org.openapitools.client.model.TimeDelta;
import org.openapitools.client.model.TriggerRule;
import org.openapitools.client.model.WeightRule;
import org.threeten.bp.OffsetDateTime;

/**
 * For details see: (airflow.models.BaseOperator)[https://airflow.apache.org/docs/apache-airflow/stable/_api/airflow/models/index.html#airflow.models.BaseOperator] 
 */
@ApiModel(description = "For details see: (airflow.models.BaseOperator)[https://airflow.apache.org/docs/apache-airflow/stable/_api/airflow/models/index.html#airflow.models.BaseOperator] ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-28T08:16:16.047364Z[Etc/UTC]")
public class Task {
  public static final String SERIALIZED_NAME_CLASS_REF = "class_ref";
  @SerializedName(SERIALIZED_NAME_CLASS_REF)
  private ClassReference classRef;

  public static final String SERIALIZED_NAME_TASK_ID = "task_id";
  @SerializedName(SERIALIZED_NAME_TASK_ID)
  private String taskId;

  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private String owner;

  public static final String SERIALIZED_NAME_START_DATE = "start_date";
  @SerializedName(SERIALIZED_NAME_START_DATE)
  private OffsetDateTime startDate;

  public static final String SERIALIZED_NAME_END_DATE = "end_date";
  @SerializedName(SERIALIZED_NAME_END_DATE)
  private OffsetDateTime endDate;

  public static final String SERIALIZED_NAME_TRIGGER_RULE = "trigger_rule";
  @SerializedName(SERIALIZED_NAME_TRIGGER_RULE)
  private TriggerRule triggerRule;

  public static final String SERIALIZED_NAME_EXTRA_LINKS = "extra_links";
  @SerializedName(SERIALIZED_NAME_EXTRA_LINKS)
  private List<TaskExtraLinks> extraLinks = null;

  public static final String SERIALIZED_NAME_DEPENDS_ON_PAST = "depends_on_past";
  @SerializedName(SERIALIZED_NAME_DEPENDS_ON_PAST)
  private Boolean dependsOnPast;

  public static final String SERIALIZED_NAME_WAIT_FOR_DOWNSTREAM = "wait_for_downstream";
  @SerializedName(SERIALIZED_NAME_WAIT_FOR_DOWNSTREAM)
  private Boolean waitForDownstream;

  public static final String SERIALIZED_NAME_RETRIES = "retries";
  @SerializedName(SERIALIZED_NAME_RETRIES)
  private BigDecimal retries;

  public static final String SERIALIZED_NAME_QUEUE = "queue";
  @SerializedName(SERIALIZED_NAME_QUEUE)
  private String queue;

  public static final String SERIALIZED_NAME_POOL = "pool";
  @SerializedName(SERIALIZED_NAME_POOL)
  private String pool;

  public static final String SERIALIZED_NAME_POOL_SLOTS = "pool_slots";
  @SerializedName(SERIALIZED_NAME_POOL_SLOTS)
  private BigDecimal poolSlots;

  public static final String SERIALIZED_NAME_EXECUTION_TIMEOUT = "execution_timeout";
  @SerializedName(SERIALIZED_NAME_EXECUTION_TIMEOUT)
  private TimeDelta executionTimeout;

  public static final String SERIALIZED_NAME_RETRY_DELAY = "retry_delay";
  @SerializedName(SERIALIZED_NAME_RETRY_DELAY)
  private TimeDelta retryDelay;

  public static final String SERIALIZED_NAME_RETRY_EXPONENTIAL_BACKOFF = "retry_exponential_backoff";
  @SerializedName(SERIALIZED_NAME_RETRY_EXPONENTIAL_BACKOFF)
  private Boolean retryExponentialBackoff;

  public static final String SERIALIZED_NAME_PRIORITY_WEIGHT = "priority_weight";
  @SerializedName(SERIALIZED_NAME_PRIORITY_WEIGHT)
  private BigDecimal priorityWeight;

  public static final String SERIALIZED_NAME_WEIGHT_RULE = "weight_rule";
  @SerializedName(SERIALIZED_NAME_WEIGHT_RULE)
  private WeightRule weightRule;

  public static final String SERIALIZED_NAME_UI_COLOR = "ui_color";
  @SerializedName(SERIALIZED_NAME_UI_COLOR)
  private String uiColor;

  public static final String SERIALIZED_NAME_UI_FGCOLOR = "ui_fgcolor";
  @SerializedName(SERIALIZED_NAME_UI_FGCOLOR)
  private String uiFgcolor;

  public static final String SERIALIZED_NAME_TEMPLATE_FIELDS = "template_fields";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_FIELDS)
  private List<String> templateFields = null;

  public static final String SERIALIZED_NAME_SUB_DAG = "sub_dag";
  @SerializedName(SERIALIZED_NAME_SUB_DAG)
  private DAG subDag;

  public static final String SERIALIZED_NAME_DOWNSTREAM_TASK_IDS = "downstream_task_ids";
  @SerializedName(SERIALIZED_NAME_DOWNSTREAM_TASK_IDS)
  private List<String> downstreamTaskIds = null;


  public Task classRef(ClassReference classRef) {
    
    this.classRef = classRef;
    return this;
  }

   /**
   * Get classRef
   * @return classRef
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ClassReference getClassRef() {
    return classRef;
  }


  public void setClassRef(ClassReference classRef) {
    this.classRef = classRef;
  }


   /**
   * Get taskId
   * @return taskId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTaskId() {
    return taskId;
  }




   /**
   * Get owner
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOwner() {
    return owner;
  }




   /**
   * Get startDate
   * @return startDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getStartDate() {
    return startDate;
  }




   /**
   * Get endDate
   * @return endDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getEndDate() {
    return endDate;
  }




  public Task triggerRule(TriggerRule triggerRule) {
    
    this.triggerRule = triggerRule;
    return this;
  }

   /**
   * Get triggerRule
   * @return triggerRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TriggerRule getTriggerRule() {
    return triggerRule;
  }


  public void setTriggerRule(TriggerRule triggerRule) {
    this.triggerRule = triggerRule;
  }


   /**
   * Get extraLinks
   * @return extraLinks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<TaskExtraLinks> getExtraLinks() {
    return extraLinks;
  }




   /**
   * Get dependsOnPast
   * @return dependsOnPast
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDependsOnPast() {
    return dependsOnPast;
  }




   /**
   * Get waitForDownstream
   * @return waitForDownstream
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getWaitForDownstream() {
    return waitForDownstream;
  }




   /**
   * Get retries
   * @return retries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BigDecimal getRetries() {
    return retries;
  }




   /**
   * Get queue
   * @return queue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getQueue() {
    return queue;
  }




   /**
   * Get pool
   * @return pool
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPool() {
    return pool;
  }




   /**
   * Get poolSlots
   * @return poolSlots
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BigDecimal getPoolSlots() {
    return poolSlots;
  }




  public Task executionTimeout(TimeDelta executionTimeout) {
    
    this.executionTimeout = executionTimeout;
    return this;
  }

   /**
   * Get executionTimeout
   * @return executionTimeout
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TimeDelta getExecutionTimeout() {
    return executionTimeout;
  }


  public void setExecutionTimeout(TimeDelta executionTimeout) {
    this.executionTimeout = executionTimeout;
  }


  public Task retryDelay(TimeDelta retryDelay) {
    
    this.retryDelay = retryDelay;
    return this;
  }

   /**
   * Get retryDelay
   * @return retryDelay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TimeDelta getRetryDelay() {
    return retryDelay;
  }


  public void setRetryDelay(TimeDelta retryDelay) {
    this.retryDelay = retryDelay;
  }


   /**
   * Get retryExponentialBackoff
   * @return retryExponentialBackoff
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getRetryExponentialBackoff() {
    return retryExponentialBackoff;
  }




   /**
   * Get priorityWeight
   * @return priorityWeight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BigDecimal getPriorityWeight() {
    return priorityWeight;
  }




  public Task weightRule(WeightRule weightRule) {
    
    this.weightRule = weightRule;
    return this;
  }

   /**
   * Get weightRule
   * @return weightRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public WeightRule getWeightRule() {
    return weightRule;
  }


  public void setWeightRule(WeightRule weightRule) {
    this.weightRule = weightRule;
  }


  public Task uiColor(String uiColor) {
    
    this.uiColor = uiColor;
    return this;
  }

   /**
   * Color in hexadecimal notation.
   * @return uiColor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Color in hexadecimal notation.")

  public String getUiColor() {
    return uiColor;
  }


  public void setUiColor(String uiColor) {
    this.uiColor = uiColor;
  }


  public Task uiFgcolor(String uiFgcolor) {
    
    this.uiFgcolor = uiFgcolor;
    return this;
  }

   /**
   * Color in hexadecimal notation.
   * @return uiFgcolor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Color in hexadecimal notation.")

  public String getUiFgcolor() {
    return uiFgcolor;
  }


  public void setUiFgcolor(String uiFgcolor) {
    this.uiFgcolor = uiFgcolor;
  }


   /**
   * Get templateFields
   * @return templateFields
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getTemplateFields() {
    return templateFields;
  }




  public Task subDag(DAG subDag) {
    
    this.subDag = subDag;
    return this;
  }

   /**
   * Get subDag
   * @return subDag
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DAG getSubDag() {
    return subDag;
  }


  public void setSubDag(DAG subDag) {
    this.subDag = subDag;
  }


   /**
   * Get downstreamTaskIds
   * @return downstreamTaskIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getDownstreamTaskIds() {
    return downstreamTaskIds;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.classRef, task.classRef) &&
        Objects.equals(this.taskId, task.taskId) &&
        Objects.equals(this.owner, task.owner) &&
        Objects.equals(this.startDate, task.startDate) &&
        Objects.equals(this.endDate, task.endDate) &&
        Objects.equals(this.triggerRule, task.triggerRule) &&
        Objects.equals(this.extraLinks, task.extraLinks) &&
        Objects.equals(this.dependsOnPast, task.dependsOnPast) &&
        Objects.equals(this.waitForDownstream, task.waitForDownstream) &&
        Objects.equals(this.retries, task.retries) &&
        Objects.equals(this.queue, task.queue) &&
        Objects.equals(this.pool, task.pool) &&
        Objects.equals(this.poolSlots, task.poolSlots) &&
        Objects.equals(this.executionTimeout, task.executionTimeout) &&
        Objects.equals(this.retryDelay, task.retryDelay) &&
        Objects.equals(this.retryExponentialBackoff, task.retryExponentialBackoff) &&
        Objects.equals(this.priorityWeight, task.priorityWeight) &&
        Objects.equals(this.weightRule, task.weightRule) &&
        Objects.equals(this.uiColor, task.uiColor) &&
        Objects.equals(this.uiFgcolor, task.uiFgcolor) &&
        Objects.equals(this.templateFields, task.templateFields) &&
        Objects.equals(this.subDag, task.subDag) &&
        Objects.equals(this.downstreamTaskIds, task.downstreamTaskIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classRef, taskId, owner, startDate, endDate, triggerRule, extraLinks, dependsOnPast, waitForDownstream, retries, queue, pool, poolSlots, executionTimeout, retryDelay, retryExponentialBackoff, priorityWeight, weightRule, uiColor, uiFgcolor, templateFields, subDag, downstreamTaskIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    sb.append("    classRef: ").append(toIndentedString(classRef)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    triggerRule: ").append(toIndentedString(triggerRule)).append("\n");
    sb.append("    extraLinks: ").append(toIndentedString(extraLinks)).append("\n");
    sb.append("    dependsOnPast: ").append(toIndentedString(dependsOnPast)).append("\n");
    sb.append("    waitForDownstream: ").append(toIndentedString(waitForDownstream)).append("\n");
    sb.append("    retries: ").append(toIndentedString(retries)).append("\n");
    sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
    sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
    sb.append("    poolSlots: ").append(toIndentedString(poolSlots)).append("\n");
    sb.append("    executionTimeout: ").append(toIndentedString(executionTimeout)).append("\n");
    sb.append("    retryDelay: ").append(toIndentedString(retryDelay)).append("\n");
    sb.append("    retryExponentialBackoff: ").append(toIndentedString(retryExponentialBackoff)).append("\n");
    sb.append("    priorityWeight: ").append(toIndentedString(priorityWeight)).append("\n");
    sb.append("    weightRule: ").append(toIndentedString(weightRule)).append("\n");
    sb.append("    uiColor: ").append(toIndentedString(uiColor)).append("\n");
    sb.append("    uiFgcolor: ").append(toIndentedString(uiFgcolor)).append("\n");
    sb.append("    templateFields: ").append(toIndentedString(templateFields)).append("\n");
    sb.append("    subDag: ").append(toIndentedString(subDag)).append("\n");
    sb.append("    downstreamTaskIds: ").append(toIndentedString(downstreamTaskIds)).append("\n");
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

