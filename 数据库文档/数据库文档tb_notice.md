# 数据库文档 

### tb_notice  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| nid  | nid | INT   |      |      |
| ntitle  | ntitle | VARCHAR   |      |      |
| ncontent  | ncontent | TEXT   |      |      |
| ntime  | ntime | DATE   |      |      |
| appendix  | 附带文件 | VARCHAR   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /notice/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"nid": nid,
	"ntitle": ntitle,
	"ncontent": ncontent,
	"ntime": ntime,
	"appendix": 附带文件,

},
.......
]
```



#### 分页查询数据  

##### url

> /notice/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /notice/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"nid": nid,
	"ntitle": ntitle,
	"ncontent": ncontent,
	"ntime": ntime,
	"appendix": 附带文件,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /notice/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /notice/findList.do
{
	"nid": nid,
	"ntitle": ntitle,
	"ncontent": ncontent,
	"ntime": ntime,
	"appendix": 附带文件,

}
```

##### 返回格式

```
[{
	"nid": nid,
	"ntitle": ntitle,
	"ncontent": ncontent,
	"ntime": ntime,
	"appendix": 附带文件,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /notice/findPage.do

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
POST /notice/findPage.do?page=1&size=10
{
	"nid": nid,
	"ntitle": ntitle,
	"ncontent": ncontent,
	"ntime": ntime,
	"appendix": 附带文件,

}
```

##### 返回格式

```
{rows:[{
	"nid": nid,
	"ntitle": ntitle,
	"ncontent": ncontent,
	"ntime": ntime,
	"appendix": 附带文件,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /notice/findById.do

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

> /notice/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| notice | true | notice | 实体对象 |

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

> /notice/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| notice | true | notice | 实体对象 |

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

> /notice/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /notice/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
