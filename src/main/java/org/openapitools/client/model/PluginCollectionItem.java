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
import java.util.ArrayList;
import java.util.List;

/**
 * Plugin Item
 */
@ApiModel(description = "Plugin Item")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-05-28T08:16:16.047364Z[Etc/UTC]")
public class PluginCollectionItem {
  public static final String SERIALIZED_NAME_NUMBER = "number";
  @SerializedName(SERIALIZED_NAME_NUMBER)
  private String number;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_HOOKS = "hooks";
  @SerializedName(SERIALIZED_NAME_HOOKS)
  private List<String> hooks = null;

  public static final String SERIALIZED_NAME_EXECUTORS = "executors";
  @SerializedName(SERIALIZED_NAME_EXECUTORS)
  private List<String> executors = null;

  public static final String SERIALIZED_NAME_MACROS = "macros";
  @SerializedName(SERIALIZED_NAME_MACROS)
  private List<Object> macros = null;

  public static final String SERIALIZED_NAME_FLASK_BLUEPRINTS = "flask_blueprints";
  @SerializedName(SERIALIZED_NAME_FLASK_BLUEPRINTS)
  private List<Object> flaskBlueprints = null;

  public static final String SERIALIZED_NAME_APPBUILDER_VIEWS = "appbuilder_views";
  @SerializedName(SERIALIZED_NAME_APPBUILDER_VIEWS)
  private List<Object> appbuilderViews = null;

  public static final String SERIALIZED_NAME_APPBUILDER_MENU_ITEMS = "appbuilder_menu_items";
  @SerializedName(SERIALIZED_NAME_APPBUILDER_MENU_ITEMS)
  private List<Object> appbuilderMenuItems = null;

  public static final String SERIALIZED_NAME_GLOBAL_OPERATOR_EXTRA_LINKS = "global_operator_extra_links";
  @SerializedName(SERIALIZED_NAME_GLOBAL_OPERATOR_EXTRA_LINKS)
  private List<Object> globalOperatorExtraLinks = null;

  public static final String SERIALIZED_NAME_OPERATOR_EXTRA_LINKS = "operator_extra_links";
  @SerializedName(SERIALIZED_NAME_OPERATOR_EXTRA_LINKS)
  private List<Object> operatorExtraLinks = null;

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private String source;


  public PluginCollectionItem number(String number) {
    
    this.number = number;
    return this;
  }

   /**
   * The plugin number
   * @return number
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The plugin number")

  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    this.number = number;
  }


  public PluginCollectionItem name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the plugin
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the plugin")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public PluginCollectionItem hooks(List<String> hooks) {
    
    this.hooks = hooks;
    return this;
  }

  public PluginCollectionItem addHooksItem(String hooksItem) {
    if (this.hooks == null) {
      this.hooks = new ArrayList<String>();
    }
    this.hooks.add(hooksItem);
    return this;
  }

   /**
   * The plugin hooks
   * @return hooks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The plugin hooks")

  public List<String> getHooks() {
    return hooks;
  }


  public void setHooks(List<String> hooks) {
    this.hooks = hooks;
  }


  public PluginCollectionItem executors(List<String> executors) {
    
    this.executors = executors;
    return this;
  }

  public PluginCollectionItem addExecutorsItem(String executorsItem) {
    if (this.executors == null) {
      this.executors = new ArrayList<String>();
    }
    this.executors.add(executorsItem);
    return this;
  }

   /**
   * The plugin executors
   * @return executors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The plugin executors")

  public List<String> getExecutors() {
    return executors;
  }


  public void setExecutors(List<String> executors) {
    this.executors = executors;
  }


  public PluginCollectionItem macros(List<Object> macros) {
    
    this.macros = macros;
    return this;
  }

  public PluginCollectionItem addMacrosItem(Object macrosItem) {
    if (this.macros == null) {
      this.macros = new ArrayList<Object>();
    }
    this.macros.add(macrosItem);
    return this;
  }

   /**
   * The plugin macros
   * @return macros
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The plugin macros")

  public List<Object> getMacros() {
    return macros;
  }


  public void setMacros(List<Object> macros) {
    this.macros = macros;
  }


  public PluginCollectionItem flaskBlueprints(List<Object> flaskBlueprints) {
    
    this.flaskBlueprints = flaskBlueprints;
    return this;
  }

  public PluginCollectionItem addFlaskBlueprintsItem(Object flaskBlueprintsItem) {
    if (this.flaskBlueprints == null) {
      this.flaskBlueprints = new ArrayList<Object>();
    }
    this.flaskBlueprints.add(flaskBlueprintsItem);
    return this;
  }

   /**
   * The flask blueprints
   * @return flaskBlueprints
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The flask blueprints")

  public List<Object> getFlaskBlueprints() {
    return flaskBlueprints;
  }


  public void setFlaskBlueprints(List<Object> flaskBlueprints) {
    this.flaskBlueprints = flaskBlueprints;
  }


  public PluginCollectionItem appbuilderViews(List<Object> appbuilderViews) {
    
    this.appbuilderViews = appbuilderViews;
    return this;
  }

  public PluginCollectionItem addAppbuilderViewsItem(Object appbuilderViewsItem) {
    if (this.appbuilderViews == null) {
      this.appbuilderViews = new ArrayList<Object>();
    }
    this.appbuilderViews.add(appbuilderViewsItem);
    return this;
  }

   /**
   * The appuilder views
   * @return appbuilderViews
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The appuilder views")

  public List<Object> getAppbuilderViews() {
    return appbuilderViews;
  }


  public void setAppbuilderViews(List<Object> appbuilderViews) {
    this.appbuilderViews = appbuilderViews;
  }


  public PluginCollectionItem appbuilderMenuItems(List<Object> appbuilderMenuItems) {
    
    this.appbuilderMenuItems = appbuilderMenuItems;
    return this;
  }

  public PluginCollectionItem addAppbuilderMenuItemsItem(Object appbuilderMenuItemsItem) {
    if (this.appbuilderMenuItems == null) {
      this.appbuilderMenuItems = new ArrayList<Object>();
    }
    this.appbuilderMenuItems.add(appbuilderMenuItemsItem);
    return this;
  }

   /**
   * The Flask Appbuilder menu items
   * @return appbuilderMenuItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The Flask Appbuilder menu items")

  public List<Object> getAppbuilderMenuItems() {
    return appbuilderMenuItems;
  }


  public void setAppbuilderMenuItems(List<Object> appbuilderMenuItems) {
    this.appbuilderMenuItems = appbuilderMenuItems;
  }


  public PluginCollectionItem globalOperatorExtraLinks(List<Object> globalOperatorExtraLinks) {
    
    this.globalOperatorExtraLinks = globalOperatorExtraLinks;
    return this;
  }

  public PluginCollectionItem addGlobalOperatorExtraLinksItem(Object globalOperatorExtraLinksItem) {
    if (this.globalOperatorExtraLinks == null) {
      this.globalOperatorExtraLinks = new ArrayList<Object>();
    }
    this.globalOperatorExtraLinks.add(globalOperatorExtraLinksItem);
    return this;
  }

   /**
   * The global operator extra links
   * @return globalOperatorExtraLinks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The global operator extra links")

  public List<Object> getGlobalOperatorExtraLinks() {
    return globalOperatorExtraLinks;
  }


  public void setGlobalOperatorExtraLinks(List<Object> globalOperatorExtraLinks) {
    this.globalOperatorExtraLinks = globalOperatorExtraLinks;
  }


  public PluginCollectionItem operatorExtraLinks(List<Object> operatorExtraLinks) {
    
    this.operatorExtraLinks = operatorExtraLinks;
    return this;
  }

  public PluginCollectionItem addOperatorExtraLinksItem(Object operatorExtraLinksItem) {
    if (this.operatorExtraLinks == null) {
      this.operatorExtraLinks = new ArrayList<Object>();
    }
    this.operatorExtraLinks.add(operatorExtraLinksItem);
    return this;
  }

   /**
   * Operator extra links
   * @return operatorExtraLinks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Operator extra links")

  public List<Object> getOperatorExtraLinks() {
    return operatorExtraLinks;
  }


  public void setOperatorExtraLinks(List<Object> operatorExtraLinks) {
    this.operatorExtraLinks = operatorExtraLinks;
  }


  public PluginCollectionItem source(String source) {
    
    this.source = source;
    return this;
  }

   /**
   * The plugin source
   * @return source
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The plugin source")

  public String getSource() {
    return source;
  }


  public void setSource(String source) {
    this.source = source;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PluginCollectionItem pluginCollectionItem = (PluginCollectionItem) o;
    return Objects.equals(this.number, pluginCollectionItem.number) &&
        Objects.equals(this.name, pluginCollectionItem.name) &&
        Objects.equals(this.hooks, pluginCollectionItem.hooks) &&
        Objects.equals(this.executors, pluginCollectionItem.executors) &&
        Objects.equals(this.macros, pluginCollectionItem.macros) &&
        Objects.equals(this.flaskBlueprints, pluginCollectionItem.flaskBlueprints) &&
        Objects.equals(this.appbuilderViews, pluginCollectionItem.appbuilderViews) &&
        Objects.equals(this.appbuilderMenuItems, pluginCollectionItem.appbuilderMenuItems) &&
        Objects.equals(this.globalOperatorExtraLinks, pluginCollectionItem.globalOperatorExtraLinks) &&
        Objects.equals(this.operatorExtraLinks, pluginCollectionItem.operatorExtraLinks) &&
        Objects.equals(this.source, pluginCollectionItem.source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, hooks, executors, macros, flaskBlueprints, appbuilderViews, appbuilderMenuItems, globalOperatorExtraLinks, operatorExtraLinks, source);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PluginCollectionItem {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hooks: ").append(toIndentedString(hooks)).append("\n");
    sb.append("    executors: ").append(toIndentedString(executors)).append("\n");
    sb.append("    macros: ").append(toIndentedString(macros)).append("\n");
    sb.append("    flaskBlueprints: ").append(toIndentedString(flaskBlueprints)).append("\n");
    sb.append("    appbuilderViews: ").append(toIndentedString(appbuilderViews)).append("\n");
    sb.append("    appbuilderMenuItems: ").append(toIndentedString(appbuilderMenuItems)).append("\n");
    sb.append("    globalOperatorExtraLinks: ").append(toIndentedString(globalOperatorExtraLinks)).append("\n");
    sb.append("    operatorExtraLinks: ").append(toIndentedString(operatorExtraLinks)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

