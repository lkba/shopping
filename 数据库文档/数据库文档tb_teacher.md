# 数据库文档 

### tb_teacher  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| id  | id | INT   |      |      |
| name  | 导师姓名 | VARCHAR   |      |      |
| phone  | phone | CHAR   |      |      |
| department  | 师导系别 | VARCHAR   |      |      |
| position  | 师导职务 | VARCHAR   |      |      |
| field  | 责负的领域 | VARCHAR   |      |      |
| tid  | 团队id | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /teacher/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"id": id,
	"name": 导师姓名,
	"phone": phone,
	"department": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tid": 团队id,

},
.......
]
```



#### 分页查询数据  

##### url

> /teacher/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /teacher/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"id": id,
	"name": 导师姓名,
	"phone": phone,
	"department": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tid": 团队id,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /teacher/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /teacher/findList.do
{
	"id": id,
	"name": 导师姓名,
	"phone": phone,
	"department": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tid": 团队id,

}
```

##### 返回格式

```
[{
	"id": id,
	"name": 导师姓名,
	"phone": phone,
	"department": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tid": 团队id,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /teacher/findPage.do

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
POST /teacher/findPage.do?page=1&size=10
{
	"id": id,
	"name": 导师姓名,
	"phone": phone,
	"department": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tid": 团队id,

}
```

##### 返回格式

```
{rows:[{
	"id": id,
	"name": 导师姓名,
	"phone": phone,
	"department": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tid": 团队id,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /teacher/findById.do

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

> /teacher/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| teacher | true | teacher | 实体对象 |

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

> /teacher/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| teacher | true | teacher | 实体对象 |

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

> /teacher/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /teacher/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
