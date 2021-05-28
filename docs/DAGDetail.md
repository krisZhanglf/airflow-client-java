

# DAGDetail

DAG details.  For details see: (airflow.models.DAG)[https://airflow.apache.org/docs/apache-airflow/stable/_api/airflow/models/index.html#airflow.models.DAG] 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dagId** | **String** | The ID of the DAG. |  [optional] [readonly]
**rootDagId** | **String** | If the DAG is SubDAG then it is the top level DAG identifier. Otherwise, null. |  [optional] [readonly]
**isPaused** | **Boolean** | Whether the DAG is paused. |  [optional]
**isSubdag** | **Boolean** | Whether the DAG is SubDAG. |  [optional] [readonly]
**fileloc** | **String** | The absolute path to the file. |  [optional] [readonly]
**fileToken** | **String** | The key containing the encrypted path to the file. Encryption and decryption take place only on the server. This prevents the client from reading an non-DAG file. This also ensures API extensibility, because the format of encrypted data may change.  |  [optional] [readonly]
**owners** | **List&lt;String&gt;** |  |  [optional] [readonly]
**description** | **String** | User-provided DAG description, which can consist of several sentences or paragraphs that describe DAG contents.  |  [optional] [readonly]
**scheduleInterval** | [**ScheduleInterval**](ScheduleInterval.md) |  |  [optional]
**tags** | [**List&lt;Tag&gt;**](Tag.md) | List of tags. |  [optional] [readonly]
**timezone** | **String** |  |  [optional]
**catchup** | **Boolean** |  |  [optional] [readonly]
**orientation** | **String** |  |  [optional] [readonly]
**concurrency** | **BigDecimal** |  |  [optional] [readonly]
**startDate** | **OffsetDateTime** |  |  [optional] [readonly]
**dagRunTimeout** | [**TimeDelta**](TimeDelta.md) |  |  [optional]
**docMd** | **String** |  |  [optional] [readonly]
**defaultView** | **String** |  |  [optional] [readonly]
**params** | **Object** |  |  [optional] [readonly]



