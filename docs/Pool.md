

# Pool

The pool

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of pool. |  [optional]
**slots** | **Integer** | The maximum number of slots that can be assigned to tasks. One job may occupy one or more slots.  |  [optional]
**occupiedSlots** | **Integer** | The number of slots used by running/queued tasks at the moment. |  [optional] [readonly]
**usedSlots** | **Integer** | The number of slots used by running tasks at the moment. |  [optional] [readonly]
**queuedSlots** | **Integer** | The number of slots used by queued tasks at the moment. |  [optional] [readonly]
**openSlots** | **Integer** | The number of free slots at the moment. |  [optional] [readonly]



