# 数据库文档 

### tb_basic_infor  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| id  | id | INT   |      |      |
| logo  | logo | VARCHAR   |      |      |
| team  | team | VARCHAR   |      |      |
| project  | project | VARCHAR   |      |      |
| in_time  | in_time | DATE   |      |      |
| registered  | registered | ENUM   |      |      |
| re_money  | 教师备注注册金额 | VARCHAR   |      |      |
| money  | money | VARCHAR   |      |      |
| reg_time  | reg_time | DATE   |      |      |
| business_scope  | business_scope | VARCHAR   |      |      |
| class  | class | ENUM   |      |      |
| tid  | tid | INT   |      |      |
| property  | 1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务 | ENUM   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /basicInfor/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"id": id,
	"logo": logo,
	"team": team,
	"project": project,
	"inTime": in_time,
	"registered": registered,
	"reMoney": 教师备注注册金额,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"tid": tid,
	"property": 1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务,

},
.......
]
```



#### 分页查询数据  

##### url

> /basicInfor/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /basicInfor/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"id": id,
	"logo": logo,
	"team": team,
	"project": project,
	"inTime": in_time,
	"registered": registered,
	"reMoney": 教师备注注册金额,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"tid": tid,
	"property": 1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /basicInfor/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /basicInfor/findList.do
{
	"id": id,
	"logo": logo,
	"team": team,
	"project": project,
	"inTime": in_time,
	"registered": registered,
	"reMoney": 教师备注注册金额,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"tid": tid,
	"property": 1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务,

}
```

##### 返回格式

```
[{
	"id": id,
	"logo": logo,
	"team": team,
	"project": project,
	"inTime": in_time,
	"registered": registered,
	"reMoney": 教师备注注册金额,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"tid": tid,
	"property": 1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /basicInfor/findPage.do

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
POST /basicInfor/findPage.do?page=1&size=10
{
	"id": id,
	"logo": logo,
	"team": team,
	"project": project,
	"inTime": in_time,
	"registered": registered,
	"reMoney": 教师备注注册金额,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"tid": tid,
	"property": 1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务,

}
```

##### 返回格式

```
{rows:[{
	"id": id,
	"logo": logo,
	"team": team,
	"project": project,
	"inTime": in_time,
	"registered": registered,
	"reMoney": 教师备注注册金额,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"tid": tid,
	"property": 1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /basicInfor/findById.do

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

> /basicInfor/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| basicInfor | true | basicInfor | 实体对象 |

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

> /basicInfor/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| basicInfor | true | basicInfor | 实体对象 |

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

> /basicInfor/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /basicInfor/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
