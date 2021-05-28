

# UpdateTaskInstancesState


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dryRun** | **Boolean** | If set, don&#39;t actually run this operation. The response will contain a list of task instances planned to be affected, but won&#39;t be modified in any way.  |  [optional]
**taskId** | **String** | The task ID. |  [optional]
**executionDate** | **String** | The execution date. |  [optional]
**includeUpstream** | **Boolean** | If set to true, upstream tasks are also affected. |  [optional]
**includeDownstream** | **Boolean** | If set to true, downstream tasks are also affected. |  [optional]
**includeFuture** | **Boolean** | If set to True, also tasks from future DAG Runs are affected. |  [optional]
**includePast** | **Boolean** | If set to True, also tasks from past DAG Runs are affected. |  [optional]
**newState** | [**NewStateEnum**](#NewStateEnum) | Expected new state. |  [optional]



## Enum: NewStateEnum

Name | Value
---- | -----
SUCCESS | &quot;success&quot;
FAILED | &quot;failed&quot;



