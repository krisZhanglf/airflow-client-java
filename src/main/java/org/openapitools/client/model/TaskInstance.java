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
import org.openapitools.client.model.SLAMiss;
import org.openapitools.client.model.TaskState;

/**
 * TaskInstance
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-28T08:16:16.047364Z[Etc/UTC]")
public class TaskInstance {
  public static final String SERIALIZED_NAME_TASK_ID = "task_id";
  @SerializedName(SERIALIZED_NAME_TASK_ID)
  private String taskId;

  public static final String SERIALIZED_NAME_DAG_ID = "dag_id";
  @SerializedName(SERIALIZED_NAME_DAG_ID)
  private String dagId;

  public static final String SERIALIZED_NAME_EXECUTION_DATE = "execution_date";
  @SerializedName(SERIALIZED_NAME_EXECUTION_DATE)
  private String executionDate;

  public static final String SERIALIZED_NAME_START_DATE = "start_date";
  @SerializedName(SERIALIZED_NAME_START_DATE)
  private String startDate;

  public static final String SERIALIZED_NAME_END_DATE = "end_date";
  @SerializedName(SERIALIZED_NAME_END_DATE)
  private String endDate;

  public static final String SERIALIZED_NAME_DURATION = "duration";
  @SerializedName(SERIALIZED_NAME_DURATION)
  private BigDecimal duration;

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private TaskState state;

  public static final String SERIALIZED_NAME_TRY_NUMBER = "try_number";
  @SerializedName(SERIALIZED_NAME_TRY_NUMBER)
  private Integer tryNumber;

  public static final String SERIALIZED_NAME_MAX_TRIES = "max_tries";
  @SerializedName(SERIALIZED_NAME_MAX_TRIES)
  private Integer maxTries;

  public static final String SERIALIZED_NAME_HOSTNAME = "hostname";
  @SerializedName(SERIALIZED_NAME_HOSTNAME)
  private String hostname;

  public static final String SERIALIZED_NAME_UNIXNAME = "unixname";
  @SerializedName(SERIALIZED_NAME_UNIXNAME)
  private String unixname;

  public static final String SERIALIZED_NAME_POOL = "pool";
  @SerializedName(SERIALIZED_NAME_POOL)
  private String pool;

  public static final String SERIALIZED_NAME_POOL_SLOTS = "pool_slots";
  @SerializedName(SERIALIZED_NAME_POOL_SLOTS)
  private Integer poolSlots;

  public static final String SERIALIZED_NAME_QUEUE = "queue";
  @SerializedName(SERIALIZED_NAME_QUEUE)
  private String queue;

  public static final String SERIALIZED_NAME_PRIORITY_WEIGHT = "priority_weight";
  @SerializedName(SERIALIZED_NAME_PRIORITY_WEIGHT)
  private Integer priorityWeight;

  public static final String SERIALIZED_NAME_OPERATOR = "operator";
  @SerializedName(SERIALIZED_NAME_OPERATOR)
  private String operator;

  public static final String SERIALIZED_NAME_QUEUED_WHEN = "queued_when";
  @SerializedName(SERIALIZED_NAME_QUEUED_WHEN)
  private String queuedWhen;

  public static final String SERIALIZED_NAME_PID = "pid";
  @SerializedName(SERIALIZED_NAME_PID)
  private Integer pid;

  public static final String SERIALIZED_NAME_EXECUTOR_CONFIG = "executor_config";
  @SerializedName(SERIALIZED_NAME_EXECUTOR_CONFIG)
  private String executorConfig;

  public static final String SERIALIZED_NAME_SLA_MISS = "sla_miss";
  @SerializedName(SERIALIZED_NAME_SLA_MISS)
  private SLAMiss slaMiss;


  public TaskInstance taskId(String taskId) {
    
    this.taskId = taskId;
    return this;
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


  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }


  public TaskInstance dagId(String dagId) {
    
    this.dagId = dagId;
    return this;
  }

   /**
   * Get dagId
   * @return dagId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDagId() {
    return dagId;
  }


  public void setDagId(String dagId) {
    this.dagId = dagId;
  }


  public TaskInstance executionDate(String executionDate) {
    
    this.executionDate = executionDate;
    return this;
  }

   /**
   * Get executionDate
   * @return executionDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getExecutionDate() {
    return executionDate;
  }


  public void setExecutionDate(String executionDate) {
    this.executionDate = executionDate;
  }


  public TaskInstance startDate(String startDate) {
    
    this.startDate = startDate;
    return this;
  }

   /**
   * Get startDate
   * @return startDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getStartDate() {
    return startDate;
  }


  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }


  public TaskInstance endDate(String endDate) {
    
    this.endDate = endDate;
    return this;
  }

   /**
   * Get endDate
   * @return endDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getEndDate() {
    return endDate;
  }


  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  public TaskInstance duration(BigDecimal duration) {
    
    this.duration = duration;
    return this;
  }

   /**
   * Get duration
   * @return duration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BigDecimal getDuration() {
    return duration;
  }


  public void setDuration(BigDecimal duration) {
    this.duration = duration;
  }


  public TaskInstance state(TaskState state) {
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TaskState getState() {
    return state;
  }


  public void setState(TaskState state) {
    this.state = state;
  }


  public TaskInstance tryNumber(Integer tryNumber) {
    
    this.tryNumber = tryNumber;
    return this;
  }

   /**
   * Get tryNumber
   * @return tryNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTryNumber() {
    return tryNumber;
  }


  public void setTryNumber(Integer tryNumber) {
    this.tryNumber = tryNumber;
  }


  public TaskInstance maxTries(Integer maxTries) {
    
    this.maxTries = maxTries;
    return this;
  }

   /**
   * Get maxTries
   * @return maxTries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getMaxTries() {
    return maxTries;
  }


  public void setMaxTries(Integer maxTries) {
    this.maxTries = maxTries;
  }


  public TaskInstance hostname(String hostname) {
    
    this.hostname = hostname;
    return this;
  }

   /**
   * Get hostname
   * @return hostname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getHostname() {
    return hostname;
  }


  public void setHostname(String hostname) {
    this.hostname = hostname;
  }


  public TaskInstance unixname(String unixname) {
    
    this.unixname = unixname;
    return this;
  }

   /**
   * Get unixname
   * @return unixname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUnixname() {
    return unixname;
  }


  public void setUnixname(String unixname) {
    this.unixname = unixname;
  }


  public TaskInstance pool(String pool) {
    
    this.pool = pool;
    return this;
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


  public void setPool(String pool) {
    this.pool = pool;
  }


  public TaskInstance poolSlots(Integer poolSlots) {
    
    this.poolSlots = poolSlots;
    return this;
  }

   /**
   * Get poolSlots
   * @return poolSlots
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getPoolSlots() {
    return poolSlots;
  }


  public void setPoolSlots(Integer poolSlots) {
    this.poolSlots = poolSlots;
  }


  public TaskInstance queue(String queue) {
    
    this.queue = queue;
    return this;
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


  public void setQueue(String queue) {
    this.queue = queue;
  }


  public TaskInstance priorityWeight(Integer priorityWeight) {
    
    this.priorityWeight = priorityWeight;
    return this;
  }

   /**
   * Get priorityWeight
   * @return priorityWeight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getPriorityWeight() {
    return priorityWeight;
  }


  public void setPriorityWeight(Integer priorityWeight) {
    this.priorityWeight = priorityWeight;
  }


  public TaskInstance operator(String operator) {
    
    this.operator = operator;
    return this;
  }

   /**
   * Get operator
   * @return operator
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOperator() {
    return operator;
  }


  public void setOperator(String operator) {
    this.operator = operator;
  }


  public TaskInstance queuedWhen(String queuedWhen) {
    
    this.queuedWhen = queuedWhen;
    return this;
  }

   /**
   * Get queuedWhen
   * @return queuedWhen
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getQueuedWhen() {
    return queuedWhen;
  }


  public void setQueuedWhen(String queuedWhen) {
    this.queuedWhen = queuedWhen;
  }


  public TaskInstance pid(Integer pid) {
    
    this.pid = pid;
    return this;
  }

   /**
   * Get pid
   * @return pid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getPid() {
    return pid;
  }


  public void setPid(Integer pid) {
    this.pid = pid;
  }


  public TaskInstance executorConfig(String executorConfig) {
    
    this.executorConfig = executorConfig;
    return this;
  }

   /**
   * Get executorConfig
   * @return executorConfig
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getExecutorConfig() {
    return executorConfig;
  }


  public void setExecutorConfig(String executorConfig) {
    this.executorConfig = executorConfig;
  }


  public TaskInstance slaMiss(SLAMiss slaMiss) {
    
    this.slaMiss = slaMiss;
    return this;
  }

   /**
   * Get slaMiss
   * @return slaMiss
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SLAMiss getSlaMiss() {
    return slaMiss;
  }


  public void setSlaMiss(SLAMiss slaMiss) {
    this.slaMiss = slaMiss;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskInstance taskInstance = (TaskInstance) o;
    return Objects.equals(this.taskId, taskInstance.taskId) &&
        Objects.equals(this.dagId, taskInstance.dagId) &&
        Objects.equals(this.executionDate, taskInstance.executionDate) &&
        Objects.equals(this.startDate, taskInstance.startDate) &&
        Objects.equals(this.endDate, taskInstance.endDate) &&
        Objects.equals(this.duration, taskInstance.duration) &&
        Objects.equals(this.state, taskInstance.state) &&
        Objects.equals(this.tryNumber, taskInstance.tryNumber) &&
        Objects.equals(this.maxTries, taskInstance.maxTries) &&
        Objects.equals(this.hostname, taskInstance.hostname) &&
        Objects.equals(this.unixname, taskInstance.unixname) &&
        Objects.equals(this.pool, taskInstance.pool) &&
        Objects.equals(this.poolSlots, taskInstance.poolSlots) &&
        Objects.equals(this.queue, taskInstance.queue) &&
        Objects.equals(this.priorityWeight, taskInstance.priorityWeight) &&
        Objects.equals(this.operator, taskInstance.operator) &&
        Objects.equals(this.queuedWhen, taskInstance.queuedWhen) &&
        Objects.equals(this.pid, taskInstance.pid) &&
        Objects.equals(this.executorConfig, taskInstance.executorConfig) &&
        Objects.equals(this.slaMiss, taskInstance.slaMiss);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, dagId, executionDate, startDate, endDate, duration, state, tryNumber, maxTries, hostname, unixname, pool, poolSlots, queue, priorityWeight, operator, queuedWhen, pid, executorConfig, slaMiss);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskInstance {\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    dagId: ").append(toIndentedString(dagId)).append("\n");
    sb.append("    executionDate: ").append(toIndentedString(executionDate)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    tryNumber: ").append(toIndentedString(tryNumber)).append("\n");
    sb.append("    maxTries: ").append(toIndentedString(maxTries)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    unixname: ").append(toIndentedString(unixname)).append("\n");
    sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
    sb.append("    poolSlots: ").append(toIndentedString(poolSlots)).append("\n");
    sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
    sb.append("    priorityWeight: ").append(toIndentedString(priorityWeight)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    queuedWhen: ").append(toIndentedString(queuedWhen)).append("\n");
    sb.append("    pid: ").append(toIndentedString(pid)).append("\n");
    sb.append("    executorConfig: ").append(toIndentedString(executorConfig)).append("\n");
    sb.append("    slaMiss: ").append(toIndentedString(slaMiss)).append("\n");
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

