# 数据库文档 

### tb_news  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| id  | id | INT   |      |      |
| title  | title | VARCHAR   |      |      |
| content  | content | VARCHAR   |      |      |
| is_read  | 1：没读；0：读取 | ENUM   |      |      |
| team_name  | team_name | VARCHAR   |      |      |
| type  | 1为系统消息；2为个人通知 | ENUM   |      |      |
| date  | 时间 | DATETIME   |      |      |
| tid  | tid | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /news/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"id": id,
	"title": title,
	"content": content,
	"isRead": 1：没读；0：读取,
	"teamName": team_name,
	"type": 1为系统消息；2为个人通知,
	"date": 时间,
	"tid": tid,

},
.......
]
```



#### 分页查询数据  

##### url

> /news/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /news/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"id": id,
	"title": title,
	"content": content,
	"isRead": 1：没读；0：读取,
	"teamName": team_name,
	"type": 1为系统消息；2为个人通知,
	"date": 时间,
	"tid": tid,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /news/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /news/findList.do
{
	"id": id,
	"title": title,
	"content": content,
	"isRead": 1：没读；0：读取,
	"teamName": team_name,
	"type": 1为系统消息；2为个人通知,
	"date": 时间,
	"tid": tid,

}
```

##### 返回格式

```
[{
	"id": id,
	"title": title,
	"content": content,
	"isRead": 1：没读；0：读取,
	"teamName": team_name,
	"type": 1为系统消息；2为个人通知,
	"date": 时间,
	"tid": tid,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /news/findPage.do

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
POST /news/findPage.do?page=1&size=10
{
	"id": id,
	"title": title,
	"content": content,
	"isRead": 1：没读；0：读取,
	"teamName": team_name,
	"type": 1为系统消息；2为个人通知,
	"date": 时间,
	"tid": tid,

}
```

##### 返回格式

```
{rows:[{
	"id": id,
	"title": title,
	"content": content,
	"isRead": 1：没读；0：读取,
	"teamName": team_name,
	"type": 1为系统消息；2为个人通知,
	"date": 时间,
	"tid": tid,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /news/findById.do

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

> /news/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| news | true | news | 实体对象 |

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

> /news/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| news | true | news | 实体对象 |

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

> /news/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /news/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
