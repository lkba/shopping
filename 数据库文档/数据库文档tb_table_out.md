# 数据库文档 

### tb_table_out  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| oid  | oid | INT   |      |      |
| base_stiu  | base_stiu | VARCHAR   |      |      |
| out_reason  | out_reason | VARCHAR   |      |      |
| idea  | idea | VARCHAR   |      |      |
| proposer  | proposer | VARCHAR   |      |      |
| outdate  | outdate | DATE   |      |      |
| workarea  | workarea | VARCHAR   |      |      |
| account  | account | VARCHAR   |      |      |
| health  | health | VARCHAR   |      |      |
| equip  | equip | VARCHAR   |      |      |
| admin_idea  | admin_idea | VARCHAR   |      |      |
| edate  | edate | DATE   |      |      |
| is_out  | 0代表退出，1代表未退出 | ENUM   |      |      |
| is_sub  | 0:未提交  1:提交 | ENUM   |      |      |
| goback  | 1退回 | ENUM   |      |      |
| tid  | tid | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /tableOut/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"oid": oid,
	"baseStiu": base_stiu,
	"outReason": out_reason,
	"idea": idea,
	"proposer": proposer,
	"outdate": outdate,
	"workarea": workarea,
	"account": account,
	"health": health,
	"equip": equip,
	"adminIdea": admin_idea,
	"edate": edate,
	"isOut": 0代表退出，1代表未退出,
	"isSub": 0:未提交  1:提交,
	"goback": 1退回,
	"tid": tid,

},
.......
]
```



#### 分页查询数据  

##### url

> /tableOut/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /tableOut/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"oid": oid,
	"baseStiu": base_stiu,
	"outReason": out_reason,
	"idea": idea,
	"proposer": proposer,
	"outdate": outdate,
	"workarea": workarea,
	"account": account,
	"health": health,
	"equip": equip,
	"adminIdea": admin_idea,
	"edate": edate,
	"isOut": 0代表退出，1代表未退出,
	"isSub": 0:未提交  1:提交,
	"goback": 1退回,
	"tid": tid,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /tableOut/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /tableOut/findList.do
{
	"oid": oid,
	"baseStiu": base_stiu,
	"outReason": out_reason,
	"idea": idea,
	"proposer": proposer,
	"outdate": outdate,
	"workarea": workarea,
	"account": account,
	"health": health,
	"equip": equip,
	"adminIdea": admin_idea,
	"edate": edate,
	"isOut": 0代表退出，1代表未退出,
	"isSub": 0:未提交  1:提交,
	"goback": 1退回,
	"tid": tid,

}
```

##### 返回格式

```
[{
	"oid": oid,
	"baseStiu": base_stiu,
	"outReason": out_reason,
	"idea": idea,
	"proposer": proposer,
	"outdate": outdate,
	"workarea": workarea,
	"account": account,
	"health": health,
	"equip": equip,
	"adminIdea": admin_idea,
	"edate": edate,
	"isOut": 0代表退出，1代表未退出,
	"isSub": 0:未提交  1:提交,
	"goback": 1退回,
	"tid": tid,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /tableOut/findPage.do

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
POST /tableOut/findPage.do?page=1&size=10
{
	"oid": oid,
	"baseStiu": base_stiu,
	"outReason": out_reason,
	"idea": idea,
	"proposer": proposer,
	"outdate": outdate,
	"workarea": workarea,
	"account": account,
	"health": health,
	"equip": equip,
	"adminIdea": admin_idea,
	"edate": edate,
	"isOut": 0代表退出，1代表未退出,
	"isSub": 0:未提交  1:提交,
	"goback": 1退回,
	"tid": tid,

}
```

##### 返回格式

```
{rows:[{
	"oid": oid,
	"baseStiu": base_stiu,
	"outReason": out_reason,
	"idea": idea,
	"proposer": proposer,
	"outdate": outdate,
	"workarea": workarea,
	"account": account,
	"health": health,
	"equip": equip,
	"adminIdea": admin_idea,
	"edate": edate,
	"isOut": 0代表退出，1代表未退出,
	"isSub": 0:未提交  1:提交,
	"goback": 1退回,
	"tid": tid,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /tableOut/findById.do

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

> /tableOut/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableOut | true | tableOut | 实体对象 |

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

> /tableOut/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableOut | true | tableOut | 实体对象 |

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

> /tableOut/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /tableOut/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
