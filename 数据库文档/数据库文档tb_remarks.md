# 数据库文档 

### tb_remarks  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| rid  | rid | INT   |      |      |
| rteam  | 入驻团队 | VARCHAR   |      |      |
| totle_team  | 团队总人数 | VARCHAR   |      |      |
| rcompany  | 已注册公司 | TEXT   |      |      |
| no_company  | 两创团队在位情况未注册公司 | VARCHAR   |      |      |
| yes_company  | 两创团队在位情况已注册公司 | VARCHAR   |      |      |
| all_company  | 两创团队在位情况 | VARCHAR   |      |      |
| out_team_1  | 因项目停止、团队解散等原因而退出 | VARCHAR   |      |      |
| out_team_2  | 已注册公司外出发展的 | VARCHAR   |      |      |
| out_team_3  | 其他  | VARCHAR   |      |      |
| out_team_all  | 退出情况 | VARCHAR   |      |      |
| reg_company_1  | 注册公司仍在位 | VARCHAR   |      |      |
| reg_company_2  | 注册公司不在位 | VARCHAR   |      |      |
| reg_company_3  | 注册公司，但项目停止 | VARCHAR   |      |      |
| reg_company_4  | 公司注销 | VARCHAR   |      |      |
| reg_company_all  | 注册公司情况 | VARCHAR   |      |      |
| pro_ent  | 相关专业创业 | VARCHAR   |      |      |
| soft  | 相关专业创业 | VARCHAR   |      |      |
| soft_pro  | 相关专业创业-相关专业创业 | VARCHAR   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /remarks/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"rid": rid,
	"rteam": 入驻团队,
	"totleTeam": 团队总人数,
	"rcompany": 已注册公司,
	"noCompany": 两创团队在位情况未注册公司,
	"yesCompany": 两创团队在位情况已注册公司,
	"allCompany": 两创团队在位情况,
	"outTeam1": 因项目停止、团队解散等原因而退出,
	"outTeam2": 已注册公司外出发展的,
	"outTeam3": 其他 ,
	"outTeamAll": 退出情况,
	"regCompany1": 注册公司仍在位,
	"regCompany2": 注册公司不在位,
	"regCompany3": 注册公司，但项目停止,
	"regCompany4": 公司注销,
	"regCompanyAll": 注册公司情况,
	"proEnt": 相关专业创业,
	"soft": 相关专业创业,
	"softPro": 相关专业创业-相关专业创业,

},
.......
]
```



#### 分页查询数据  

##### url

> /remarks/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /remarks/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"rid": rid,
	"rteam": 入驻团队,
	"totleTeam": 团队总人数,
	"rcompany": 已注册公司,
	"noCompany": 两创团队在位情况未注册公司,
	"yesCompany": 两创团队在位情况已注册公司,
	"allCompany": 两创团队在位情况,
	"outTeam1": 因项目停止、团队解散等原因而退出,
	"outTeam2": 已注册公司外出发展的,
	"outTeam3": 其他 ,
	"outTeamAll": 退出情况,
	"regCompany1": 注册公司仍在位,
	"regCompany2": 注册公司不在位,
	"regCompany3": 注册公司，但项目停止,
	"regCompany4": 公司注销,
	"regCompanyAll": 注册公司情况,
	"proEnt": 相关专业创业,
	"soft": 相关专业创业,
	"softPro": 相关专业创业-相关专业创业,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /remarks/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /remarks/findList.do
{
	"rid": rid,
	"rteam": 入驻团队,
	"totleTeam": 团队总人数,
	"rcompany": 已注册公司,
	"noCompany": 两创团队在位情况未注册公司,
	"yesCompany": 两创团队在位情况已注册公司,
	"allCompany": 两创团队在位情况,
	"outTeam1": 因项目停止、团队解散等原因而退出,
	"outTeam2": 已注册公司外出发展的,
	"outTeam3": 其他 ,
	"outTeamAll": 退出情况,
	"regCompany1": 注册公司仍在位,
	"regCompany2": 注册公司不在位,
	"regCompany3": 注册公司，但项目停止,
	"regCompany4": 公司注销,
	"regCompanyAll": 注册公司情况,
	"proEnt": 相关专业创业,
	"soft": 相关专业创业,
	"softPro": 相关专业创业-相关专业创业,

}
```

##### 返回格式

```
[{
	"rid": rid,
	"rteam": 入驻团队,
	"totleTeam": 团队总人数,
	"rcompany": 已注册公司,
	"noCompany": 两创团队在位情况未注册公司,
	"yesCompany": 两创团队在位情况已注册公司,
	"allCompany": 两创团队在位情况,
	"outTeam1": 因项目停止、团队解散等原因而退出,
	"outTeam2": 已注册公司外出发展的,
	"outTeam3": 其他 ,
	"outTeamAll": 退出情况,
	"regCompany1": 注册公司仍在位,
	"regCompany2": 注册公司不在位,
	"regCompany3": 注册公司，但项目停止,
	"regCompany4": 公司注销,
	"regCompanyAll": 注册公司情况,
	"proEnt": 相关专业创业,
	"soft": 相关专业创业,
	"softPro": 相关专业创业-相关专业创业,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /remarks/findPage.do

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
POST /remarks/findPage.do?page=1&size=10
{
	"rid": rid,
	"rteam": 入驻团队,
	"totleTeam": 团队总人数,
	"rcompany": 已注册公司,
	"noCompany": 两创团队在位情况未注册公司,
	"yesCompany": 两创团队在位情况已注册公司,
	"allCompany": 两创团队在位情况,
	"outTeam1": 因项目停止、团队解散等原因而退出,
	"outTeam2": 已注册公司外出发展的,
	"outTeam3": 其他 ,
	"outTeamAll": 退出情况,
	"regCompany1": 注册公司仍在位,
	"regCompany2": 注册公司不在位,
	"regCompany3": 注册公司，但项目停止,
	"regCompany4": 公司注销,
	"regCompanyAll": 注册公司情况,
	"proEnt": 相关专业创业,
	"soft": 相关专业创业,
	"softPro": 相关专业创业-相关专业创业,

}
```

##### 返回格式

```
{rows:[{
	"rid": rid,
	"rteam": 入驻团队,
	"totleTeam": 团队总人数,
	"rcompany": 已注册公司,
	"noCompany": 两创团队在位情况未注册公司,
	"yesCompany": 两创团队在位情况已注册公司,
	"allCompany": 两创团队在位情况,
	"outTeam1": 因项目停止、团队解散等原因而退出,
	"outTeam2": 已注册公司外出发展的,
	"outTeam3": 其他 ,
	"outTeamAll": 退出情况,
	"regCompany1": 注册公司仍在位,
	"regCompany2": 注册公司不在位,
	"regCompany3": 注册公司，但项目停止,
	"regCompany4": 公司注销,
	"regCompanyAll": 注册公司情况,
	"proEnt": 相关专业创业,
	"soft": 相关专业创业,
	"softPro": 相关专业创业-相关专业创业,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /remarks/findById.do

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

> /remarks/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| remarks | true | remarks | 实体对象 |

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

> /remarks/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| remarks | true | remarks | 实体对象 |

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

> /remarks/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /remarks/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
