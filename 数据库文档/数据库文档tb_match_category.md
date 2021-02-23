# 数据库文档 

### tb_match_category  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| cid  | cid | INT   |      |      |
| cname  | 分类名称 | VARCHAR   |      |      |
| pid  | pid | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /matchCategory/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"cid": cid,
	"cname": 分类名称,
	"pid": pid,

},
.......
]
```



#### 分页查询数据  

##### url

> /matchCategory/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /matchCategory/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"cid": cid,
	"cname": 分类名称,
	"pid": pid,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /matchCategory/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /matchCategory/findList.do
{
	"cid": cid,
	"cname": 分类名称,
	"pid": pid,

}
```

##### 返回格式

```
[{
	"cid": cid,
	"cname": 分类名称,
	"pid": pid,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /matchCategory/findPage.do

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
POST /matchCategory/findPage.do?page=1&size=10
{
	"cid": cid,
	"cname": 分类名称,
	"pid": pid,

}
```

##### 返回格式

```
{rows:[{
	"cid": cid,
	"cname": 分类名称,
	"pid": pid,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /matchCategory/findById.do

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

> /matchCategory/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| matchCategory | true | matchCategory | 实体对象 |

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

> /matchCategory/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| matchCategory | true | matchCategory | 实体对象 |

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

> /matchCategory/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /matchCategory/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
