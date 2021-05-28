# XComApi

All URIs are relative to *http://localhost/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getXcomEntries**](XComApi.md#getXcomEntries) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/xcomEntries | List XCom entries
[**getXcomEntry**](XComApi.md#getXcomEntry) | **GET** /dags/{dag_id}/dagRuns/{dag_run_id}/taskInstances/{task_id}/xcomEntries/{xcom_key} | Get an XCom entry


<a name="getXcomEntries"></a>
# **getXcomEntries**
> XComCollection getXcomEntries(dagId, dagRunId, taskId, limit, offset)

List XCom entries

This endpoint allows specifying &#x60;~&#x60; as the dag_id, dag_run_id, task_id to retrieve XCOM entries for for all DAGs, DAG runs and task instances. XCom values won&#39;t be returned as they can be large. Use this endpoint to get a list of XCom entries and then fetch individual entry to get value.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.XComApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api/v1");

    XComApi apiInstance = new XComApi(defaultClient);
    String dagId = "dagId_example"; // String | The DAG ID.
    String dagRunId = "dagRunId_example"; // String | The DAG run ID.
    String taskId = "taskId_example"; // String | The task ID.
    Integer limit = 100; // Integer | The numbers of items to return.
    Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
    try {
      XComCollection result = apiInstance.getXcomEntries(dagId, dagRunId, taskId, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling XComApi#getXcomEntries");
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
 **limit** | **Integer**| The numbers of items to return. | [optional] [default to 100]
 **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional]

### Return type

[**XComCollection**](XComCollection.md)

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

<a name="getXcomEntry"></a>
# **getXcomEntry**
> XCom getXcomEntry(dagId, dagRunId, taskId, xcomKey)

Get an XCom entry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.XComApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api/v1");

    XComApi apiInstance = new XComApi(defaultClient);
    String dagId = "dagId_example"; // String | The DAG ID.
    String dagRunId = "dagRunId_example"; // String | The DAG run ID.
    String taskId = "taskId_example"; // String | The task ID.
    String xcomKey = "xcomKey_example"; // String | The XCom key.
    try {
      XCom result = apiInstance.getXcomEntry(dagId, dagRunId, taskId, xcomKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling XComApi#getXcomEntry");
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
 **xcomKey** | **String**| The XCom key. |

### Return type

[**XCom**](XCom.md)

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

