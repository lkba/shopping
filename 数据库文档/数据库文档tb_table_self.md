# 数据库文档 

### tb_table_self  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| sid  | sid | INT   |      |      |
| situation  | situation | VARCHAR   |      |      |
| progress  | progress | VARCHAR   |      |      |
| plan  | plan | VARCHAR   |      |      |
| prize  | prize | VARCHAR   |      |      |
| admin_idea  | admin_idea | VARCHAR   |      |      |
| hatch  | hatch | VARCHAR   |      |      |
| department_idea  | department_idea | VARCHAR   |      |      |
| self_date_id  | self_date_id | INT   |      |      |
| is_self  | 1未自查，0自查 | ENUM   |      |      |
| is_sub  | 0 ：未提交    1：提交 | ENUM   |      |      |
| date  | date | DATE   |      |      |
| tid  | tid | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /tableSelf/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"sid": sid,
	"situation": situation,
	"progress": progress,
	"plan": plan,
	"prize": prize,
	"adminIdea": admin_idea,
	"hatch": hatch,
	"departmentIdea": department_idea,
	"selfDateId": self_date_id,
	"isSelf": 1未自查，0自查,
	"isSub": 0 ：未提交    1：提交,
	"date": date,
	"tid": tid,

},
.......
]
```



#### 分页查询数据  

##### url

> /tableSelf/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /tableSelf/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"sid": sid,
	"situation": situation,
	"progress": progress,
	"plan": plan,
	"prize": prize,
	"adminIdea": admin_idea,
	"hatch": hatch,
	"departmentIdea": department_idea,
	"selfDateId": self_date_id,
	"isSelf": 1未自查，0自查,
	"isSub": 0 ：未提交    1：提交,
	"date": date,
	"tid": tid,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /tableSelf/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /tableSelf/findList.do
{
	"sid": sid,
	"situation": situation,
	"progress": progress,
	"plan": plan,
	"prize": prize,
	"adminIdea": admin_idea,
	"hatch": hatch,
	"departmentIdea": department_idea,
	"selfDateId": self_date_id,
	"isSelf": 1未自查，0自查,
	"isSub": 0 ：未提交    1：提交,
	"date": date,
	"tid": tid,

}
```

##### 返回格式

```
[{
	"sid": sid,
	"situation": situation,
	"progress": progress,
	"plan": plan,
	"prize": prize,
	"adminIdea": admin_idea,
	"hatch": hatch,
	"departmentIdea": department_idea,
	"selfDateId": self_date_id,
	"isSelf": 1未自查，0自查,
	"isSub": 0 ：未提交    1：提交,
	"date": date,
	"tid": tid,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /tableSelf/findPage.do

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
POST /tableSelf/findPage.do?page=1&size=10
{
	"sid": sid,
	"situation": situation,
	"progress": progress,
	"plan": plan,
	"prize": prize,
	"adminIdea": admin_idea,
	"hatch": hatch,
	"departmentIdea": department_idea,
	"selfDateId": self_date_id,
	"isSelf": 1未自查，0自查,
	"isSub": 0 ：未提交    1：提交,
	"date": date,
	"tid": tid,

}
```

##### 返回格式

```
{rows:[{
	"sid": sid,
	"situation": situation,
	"progress": progress,
	"plan": plan,
	"prize": prize,
	"adminIdea": admin_idea,
	"hatch": hatch,
	"departmentIdea": department_idea,
	"selfDateId": self_date_id,
	"isSelf": 1未自查，0自查,
	"isSub": 0 ：未提交    1：提交,
	"date": date,
	"tid": tid,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /tableSelf/findById.do

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

> /tableSelf/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableSelf | true | tableSelf | 实体对象 |

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

> /tableSelf/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableSelf | true | tableSelf | 实体对象 |

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

> /tableSelf/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /tableSelf/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
