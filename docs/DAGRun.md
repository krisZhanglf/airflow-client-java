

# DAGRun


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dagRunId** | **String** | Run ID.  The value of this field can be set only when creating the object. If you try to modify the field of an existing object, the request fails with an BAD_REQUEST error.  If not provided, a value will be generated based on execution_date.  If the specified dag_run_id is in use, the creation request fails with an ALREADY_EXISTS error.  This together with DAG_ID are a unique key.  |  [optional]
**dagId** | **String** |  |  [readonly]
**executionDate** | **OffsetDateTime** | The execution date. This is the time when the DAG run should be started according to the DAG definition. The value of this field can be set only when creating the object. If you try to modify the field of an existing object, the request fails with an BAD_REQUEST error. This together with DAG_ID are a unique key.  |  [optional]
**startDate** | **OffsetDateTime** | The start time. The time when DAG run was actually created.  |  [optional] [readonly]
**endDate** | **OffsetDateTime** |  |  [optional] [readonly]
**state** | **DagState** |  |  [optional]
**externalTrigger** | **Boolean** |  |  [optional] [readonly]
**conf** | **Object** | JSON object describing additional configuration parameters.  The value of this field can be set only when creating the object. If you try to modify the field of an existing object, the request fails with an BAD_REQUEST error.  |  [optional]



