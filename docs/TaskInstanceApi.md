# TaskInstanceApi

All URIs are relative to *http://localhost/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getExtraLinks**](TaskInstanceApi.md#getExtraLinks) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/links | List extra links
[**getLog**](TaskInstanceApi.md#getLog) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/logs/{task_try_number} | Get logs
[**getTaskInstance**](TaskInstanceApi.md#getTaskInstance) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id} | Get a task instance
[**getTaskInstances**](TaskInstanceApi.md#getTaskInstances) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances | List task instances
[**getTaskInstancesBatch**](TaskInstanceApi.md#getTaskInstancesBatch) | **POST** /dags/~/dagRuns/~/taskInstances/list | List task instances (batch)


<a name="getExtraLinks"></a>
# **getExtraLinks**
> ExtraLinkCollection getExtraLinks(dagId, dagRunId, taskId)

List extra links

List extra links for task instance. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TaskInstanceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api/v1");

    TaskInstanceApi apiInstance = new TaskInstanceApi(defaultClient);
    String dagId = "dagId_example"; // String | The DAG ID.
    String dagRunId = "dagRunId_example"; // String | The DAG run ID.
    String taskId = "taskId_example"; // String | The task ID.
    try {
      ExtraLinkCollection result = apiInstance.getExtraLinks(dagId, dagRunId, taskId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskInstanceApi#getExtraLinks");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |
 **taskId** | **String**| The task ID. |

### Return type

[**ExtraLinkCollection**](ExtraLinkCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success. |  -  |
**401** | Request not authenticated due to missing, invalid, authentication info. |  -  |
**403** | Client does not have sufficient permission. |  -  |
**404** | A specified resource is not found. |  -  |

<a name="getLog"></a>
# **getLog**
> InlineResponse200 getLog(dagId, dagRunId, taskId, taskTryNumber, fullContent, token)

Get logs

Get logs for a specific task instance and its try number.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TaskInstanceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api/v1");

    TaskInstanceApi apiInstance = new TaskInstanceApi(defaultClient);
    String dagId = "dagId_example"; // String | The DAG ID.
    String dagRunId = "dagRunId_example"; // String | The DAG run ID.
    String taskId = "taskId_example"; // String | The task ID.
    Integer taskTryNumber = 56; // Integer | The task try number.
    Boolean fullContent = true; // Boolean | A full content will be returned. By default, only the first fragment will be returned. 
    String token = "token_example"; // String | A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued. 
    try {
      InlineResponse200 result = apiInstance.getLog(dagId, dagRunId, taskId, taskTryNumber, fullContent, token);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskInstanceApi#getLog");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |
 **taskId** | **String**| The task ID. |
 **taskTryNumber** | **Integer**| The task try number. |
 **fullContent** | **Boolean**| A full content will be returned. By default, only the first fragment will be returned.  | [optional]
 **token** | **String**| A token that allows you to continue fetching logs. If passed, it will specify the location from which the download should be continued.  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success. |  -  |
**400** | Client specified an invalid argument. |  -  |
**401** | Request not authenticated due to missing, invalid, authentication info. |  -  |
**403** | Client does not have sufficient permission. |  -  |
**404** | A specified resource is not found. |  -  |

<a name="getTaskInstance"></a>
# **getTaskInstance**
> TaskInstance getTaskInstance(dagId, dagRunId, taskId)

Get a task instance

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TaskInstanceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api/v1");

    TaskInstanceApi apiInstance = new TaskInstanceApi(defaultClient);
    String dagId = "dagId_example"; // String | The DAG ID.
    String dagRunId = "dagRunId_example"; // String | The DAG run ID.
    String taskId = "taskId_example"; // String | The task ID.
    try {
      TaskInstance result = apiInstance.getTaskInstance(dagId, dagRunId, taskId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskInstanceApi#getTaskInstance");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |
 **taskId** | **String**| The task ID. |

### Return type

[**TaskInstance**](TaskInstance.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success. |  -  |
**401** | Request not authenticated due to missing, invalid, authentication info. |  -  |
**403** | Client does not have sufficient permission. |  -  |
**404** | A specified resource is not found. |  -  |

<a name="getTaskInstances"></a>
# **getTaskInstances**
> TaskInstanceCollection getTaskInstances(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset)

List task instances

This endpoint allows specifying &#x60;~&#x60; as the dag_id, dag_run_id to retrieve DAG runs for all DAGs and DAG runs. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TaskInstanceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api/v1");

    TaskInstanceApi apiInstance = new TaskInstanceApi(defaultClient);
    String dagId = "dagId_example"; // String | The DAG ID.
    String dagRunId = "dagRunId_example"; // String | The DAG run ID.
    OffsetDateTime executionDateGte = OffsetDateTime.now(); // OffsetDateTime | Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period. 
    OffsetDateTime executionDateLte = OffsetDateTime.now(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period. 
    OffsetDateTime startDateGte = OffsetDateTime.now(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
    OffsetDateTime startDateLte = OffsetDateTime.now(); // OffsetDateTime | Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
    OffsetDateTime endDateGte = OffsetDateTime.now(); // OffsetDateTime | Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period. 
    OffsetDateTime endDateLte = OffsetDateTime.now(); // OffsetDateTime | Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period. 
    BigDecimal durationGte = new BigDecimal(78); // BigDecimal | Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period. 
    BigDecimal durationLte = new BigDecimal(78); // BigDecimal | Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range. 
    List<String> state = Arrays.asList(); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
    List<String> pool = Arrays.asList(); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
    List<String> queue = Arrays.asList(); // List<String> | The value can be repeated to retrieve multiple matching values (OR condition).
    Integer limit = 100; // Integer | The numbers of items to return.
    Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
    try {
      TaskInstanceCollection result = apiInstance.getTaskInstances(dagId, dagRunId, executionDateGte, executionDateLte, startDateGte, startDateLte, endDateGte, endDateLte, durationGte, durationLte, state, pool, queue, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskInstanceApi#getTaskInstances");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dagId** | **String**| The DAG ID. |
 **dagRunId** | **String**| The DAG run ID. |
 **executionDateGte** | **OffsetDateTime**| Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte parameter to receive only the selected period.  | [optional]
 **executionDateLte** | **OffsetDateTime**| Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte parameter to receive only the selected period.  | [optional]
 **startDateGte** | **OffsetDateTime**| Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  | [optional]
 **startDateLte** | **OffsetDateTime**| Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  | [optional]
 **endDateGte** | **OffsetDateTime**| Returns objects greater or equal the specified date.  This can be combined with start_date_lte parameter to receive only the selected period.  | [optional]
 **endDateLte** | **OffsetDateTime**| Returns objects less than or equal to the specified date.  This can be combined with start_date_gte parameter to receive only the selected period.  | [optional]
 **durationGte** | **BigDecimal**| Returns objects greater than or equal to the specified values.  This can be combined with duration_lte parameter to receive only the selected period.  | [optional]
 **durationLte** | **BigDecimal**| Returns objects less than or equal to the specified values.  This can be combined with duration_gte parameter to receive only the selected range.  | [optional]
 **state** | [**List&lt;String&gt;**](String.md)| The value can be repeated to retrieve multiple matching values (OR condition). | [optional]
 **pool** | [**List&lt;String&gt;**](String.md)| The value can be repeated to retrieve multiple matching values (OR condition). | [optional]
 **queue** | [**List&lt;String&gt;**](String.md)| The value can be repeated to retrieve multiple matching values (OR condition). | [optional]
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional]

### Return type

[**TaskInstanceCollection**](TaskInstanceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success. |  -  |
**401** | Request not authenticated due to missing, invalid, authentication info. |  -  |
**403** | Client does not have sufficient permission. |  -  |

<a name="getTaskInstancesBatch"></a>
# **getTaskInstancesBatch**
> TaskInstanceCollection getTaskInstancesBatch(listTaskInstanceForm)

List task instances (batch)

List task instances from all DAGs and DAG runs. This endpoint is a POST to allow filtering across a large number of DAG IDs, where as a GET it would run in to maximum HTTP request URL length limits. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TaskInstanceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api/v1");

    TaskInstanceApi apiInstance = new TaskInstanceApi(defaultClient);
    ListTaskInstanceForm listTaskInstanceForm = new ListTaskInstanceForm(); // ListTaskInstanceForm | 
    try {
      TaskInstanceCollection result = apiInstance.getTaskInstancesBatch(listTaskInstanceForm);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskInstanceApi#getTaskInstancesBatch");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **listTaskInstanceForm** | [**ListTaskInstanceForm**](ListTaskInstanceForm.md)|  |

### Return type

[**TaskInstanceCollection**](TaskInstanceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success. |  -  |
**401** | Request not authenticated due to missing, invalid, authentication info. |  -  |
**403** | Client does not have sufficient permission. |  -  |
**404** | A specified resource is not found. |  -  |

