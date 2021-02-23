# 数据库文档 

### tb_news_manypop  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| id  | 发信息给多个团队 | INT   |      |      |
| tid  | tid | INT   |      |      |
| is_read  | 1：没读；0：读取 | ENUM   |      |      |
| nid  | 新闻id | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /newsManypop/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"id": 发信息给多个团队,
	"tid": tid,
	"isRead": 1：没读；0：读取,
	"nid": 新闻id,

},
.......
]
```



#### 分页查询数据  

##### url

> /newsManypop/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /newsManypop/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"id": 发信息给多个团队,
	"tid": tid,
	"isRead": 1：没读；0：读取,
	"nid": 新闻id,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /newsManypop/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /newsManypop/findList.do
{
	"id": 发信息给多个团队,
	"tid": tid,
	"isRead": 1：没读；0：读取,
	"nid": 新闻id,

}
```

##### 返回格式

```
[{
	"id": 发信息给多个团队,
	"tid": tid,
	"isRead": 1：没读；0：读取,
	"nid": 新闻id,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /newsManypop/findPage.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |
| page      | true | int  | 页码（GET）      |
| size      | true | int  | 每页记录数（GET）   |

例子：

```
POST /newsManypop/findPage.do?page=1&size=10
{
	"id": 发信息给多个团队,
	"tid": tid,
	"isRead": 1：没读；0：读取,
	"nid": 新闻id,

}
```

##### 返回格式

```
{rows:[{
	"id": 发信息给多个团队,
	"tid": tid,
	"isRead": 1：没读；0：读取,
	"nid": 新闻id,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /newsManypop/findById.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键  |

例子：

```

```



#### 增加数据  

##### url

> /newsManypop/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| newsManypop | true | newsManypop | 实体对象 |

##### 返回格式

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败



#### 修改数据  

##### url

> /newsManypop/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| newsManypop | true | newsManypop | 实体对象 |

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败



#### 删除数据  

##### url

> /newsManypop/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /newsManypop/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
