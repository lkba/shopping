# 数据库文档 

### tb_temp_teacher  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| id  | id | INT   |      |      |
| tname  | 导师姓名 | VARCHAR   |      |      |
| tdepartment  | 师导系别 | VARCHAR   |      |      |
| position  | 师导职务 | VARCHAR   |      |      |
| field  | 责负的领域 | VARCHAR   |      |      |
| tpid  | 临时id | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /tempTeacher/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"id": id,
	"tname": 导师姓名,
	"tdepartment": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tpid": 临时id,

},
.......
]
```



#### 分页查询数据  

##### url

> /tempTeacher/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /tempTeacher/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"id": id,
	"tname": 导师姓名,
	"tdepartment": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tpid": 临时id,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /tempTeacher/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /tempTeacher/findList.do
{
	"id": id,
	"tname": 导师姓名,
	"tdepartment": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tpid": 临时id,

}
```

##### 返回格式

```
[{
	"id": id,
	"tname": 导师姓名,
	"tdepartment": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tpid": 临时id,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /tempTeacher/findPage.do

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
POST /tempTeacher/findPage.do?page=1&size=10
{
	"id": id,
	"tname": 导师姓名,
	"tdepartment": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tpid": 临时id,

}
```

##### 返回格式

```
{rows:[{
	"id": id,
	"tname": 导师姓名,
	"tdepartment": 师导系别,
	"position": 师导职务,
	"field": 责负的领域,
	"tpid": 临时id,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /tempTeacher/findById.do

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

> /tempTeacher/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tempTeacher | true | tempTeacher | 实体对象 |

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

> /tempTeacher/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tempTeacher | true | tempTeacher | 实体对象 |

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

> /tempTeacher/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /tempTeacher/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
