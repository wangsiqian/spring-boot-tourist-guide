# spring-boot-tourist-guide

## api 开发流程

### 1. 测试
1. 先设计 api，然后写测试，遵循 TDD 开发

### 2. 添加 api
1. 在 `model` 中添加数据库对应模型
3. 在 `service` 中添加业务逻辑
4. 在 `controller` 中添加 api 处理类
5. 在 `validator` 添加自定义数据验证
6. 在 `exception` 添加自定义异常

### 3. 添加文档
暂使用swagger自动添加文档

## Overview

语言导游项目，前端定位用户地址获取附近的景点，返回图片、音频、景点介绍等数据

- Web 框架：SpringBoot
- 搜索引擎：Elasticsearch
- 代码检测：p3c
