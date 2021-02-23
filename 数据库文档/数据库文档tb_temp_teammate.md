# 数据库文档 

### tb_temp_teammate  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| id  | id | INT   |      |      |
| dname  | dname | VARCHAR   |      |      |
| dsex  | dsex | ENUM   |      |      |
| ddepartment  | ddepartment | VARCHAR   |      |      |
| dprofessional  | dprofessional | VARCHAR   |      |      |
| dphone  | dphone | VARCHAR   |      |      |
| demail  | demail | VARCHAR   |      |      |
| tpid  | tpid | VARCHAR   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /tempTeammate/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"id": id,
	"dname": dname,
	"dsex": dsex,
	"ddepartment": ddepartment,
	"dprofessional": dprofessional,
	"dphone": dphone,
	"demail": demail,
	"tpid": tpid,

},
.......
]
```



#### 分页查询数据  

##### url

> /tempTeammate/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /tempTeammate/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"id": id,
	"dname": dname,
	"dsex": dsex,
	"ddepartment": ddepartment,
	"dprofessional": dprofessional,
	"dphone": dphone,
	"demail": demail,
	"tpid": tpid,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /tempTeammate/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /tempTeammate/findList.do
{
	"id": id,
	"dname": dname,
	"dsex": dsex,
	"ddepartment": ddepartment,
	"dprofessional": dprofessional,
	"dphone": dphone,
	"demail": demail,
	"tpid": tpid,

}
```

##### 返回格式

```
[{
	"id": id,
	"dname": dname,
	"dsex": dsex,
	"ddepartment": ddepartment,
	"dprofessional": dprofessional,
	"dphone": dphone,
	"demail": demail,
	"tpid": tpid,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /tempTeammate/findPage.do

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
POST /tempTeammate/findPage.do?page=1&size=10
{
	"id": id,
	"dname": dname,
	"dsex": dsex,
	"ddepartment": ddepartment,
	"dprofessional": dprofessional,
	"dphone": dphone,
	"demail": demail,
	"tpid": tpid,

}
```

##### 返回格式

```
{rows:[{
	"id": id,
	"dname": dname,
	"dsex": dsex,
	"ddepartment": ddepartment,
	"dprofessional": dprofessional,
	"dphone": dphone,
	"demail": demail,
	"tpid": tpid,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /tempTeammate/findById.do

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

> /tempTeammate/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tempTeammate | true | tempTeammate | 实体对象 |

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

> /tempTeammate/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tempTeammate | true | tempTeammate | 实体对象 |

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

> /tempTeammate/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /tempTeammate/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
