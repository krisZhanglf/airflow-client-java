

# EventLog

Log of user operations via CLI or Web UI.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**eventLogId** | **Integer** | The event log ID |  [optional] [readonly]
**when** | **OffsetDateTime** | The time when these events happened. |  [optional] [readonly]
**dagId** | **String** | The DAG ID |  [optional] [readonly]
**taskId** | **String** | The DAG ID |  [optional] [readonly]
**event** | **String** | A key describing the type of event. |  [optional] [readonly]
**executionDate** | **OffsetDateTime** | When the event was dispatched for an object having execution_date, the value of this field.  |  [optional] [readonly]
**owner** | **String** | Name of the user who triggered these events a. |  [optional] [readonly]
**extra** | **String** | Other information that was not included in the other fields, e.g. the complete CLI command.  |  [optional] [readonly]



