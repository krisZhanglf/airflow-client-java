

# Task

For details see: (airflow.models.BaseOperator)[https://airflow.apache.org/docs/apache-airflow/stable/_api/airflow/models/index.html#airflow.models.BaseOperator] 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**classRef** | [**ClassReference**](ClassReference.md) |  |  [optional]
**taskId** | **String** |  |  [optional] [readonly]
**owner** | **String** |  |  [optional] [readonly]
**startDate** | **OffsetDateTime** |  |  [optional] [readonly]
**endDate** | **OffsetDateTime** |  |  [optional] [readonly]
**triggerRule** | **TriggerRule** |  |  [optional]
**extraLinks** | [**List&lt;TaskExtraLinks&gt;**](TaskExtraLinks.md) |  |  [optional] [readonly]
**dependsOnPast** | **Boolean** |  |  [optional] [readonly]
**waitForDownstream** | **Boolean** |  |  [optional] [readonly]
**retries** | **BigDecimal** |  |  [optional] [readonly]
**queue** | **String** |  |  [optional] [readonly]
**pool** | **String** |  |  [optional] [readonly]
**poolSlots** | **BigDecimal** |  |  [optional] [readonly]
**executionTimeout** | [**TimeDelta**](TimeDelta.md) |  |  [optional]
**retryDelay** | [**TimeDelta**](TimeDelta.md) |  |  [optional]
**retryExponentialBackoff** | **Boolean** |  |  [optional] [readonly]
**priorityWeight** | **BigDecimal** |  |  [optional] [readonly]
**weightRule** | **WeightRule** |  |  [optional]
**uiColor** | **String** | Color in hexadecimal notation. |  [optional]
**uiFgcolor** | **String** | Color in hexadecimal notation. |  [optional]
**templateFields** | **List&lt;String&gt;** |  |  [optional] [readonly]
**subDag** | [**DAG**](DAG.md) |  |  [optional]
**downstreamTaskIds** | **List&lt;String&gt;** |  |  [optional] [readonly]



