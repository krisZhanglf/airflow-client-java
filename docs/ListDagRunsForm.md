

# ListDagRunsForm


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**orderBy** | **String** | The name of the field to order the results by. Prefix a field name with &#x60;-&#x60; to reverse the sort order.  |  [optional]
**pageOffset** | **Integer** | The number of items to skip before starting to collect the result set. |  [optional]
**pageLimit** | **Integer** | The numbers of items to return. |  [optional]
**dagIds** | **List&lt;String&gt;** | Return objects with specific DAG IDs. The value can be repeated to retrieve multiple matching values (OR condition). |  [optional]
**executionDateGte** | **OffsetDateTime** | Returns objects greater or equal to the specified date.  This can be combined with execution_date_lte key to receive only the selected period.  |  [optional]
**executionDateLte** | **OffsetDateTime** | Returns objects less than or equal to the specified date.  This can be combined with execution_date_gte key to receive only the selected period.  |  [optional]
**startDateGte** | **OffsetDateTime** | Returns objects greater or equal the specified date.  This can be combined with start_date_lte key to receive only the selected period.  |  [optional]
**startDateLte** | **OffsetDateTime** | Returns objects less or equal the specified date.  This can be combined with start_date_gte parameter to receive only the selected period  |  [optional]
**endDateGte** | **OffsetDateTime** | Returns objects greater or equal the specified date.  This can be combined with end_date_lte parameter to receive only the selected period.  |  [optional]
**endDateLte** | **OffsetDateTime** | Returns objects less than or equal to the specified date.  This can be combined with end_date_gte parameter to receive only the selected period.  |  [optional]



