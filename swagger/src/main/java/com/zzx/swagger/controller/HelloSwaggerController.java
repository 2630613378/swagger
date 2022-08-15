package com.zzx.swagger.controller;


import com.zzx.swagger.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "swagger学习类")
@RequestMapping("/swagger")
@RestController
public class HelloSwaggerController {

    @GetMapping("/hello")
    public String helloSwagger(){
        return "helloSwagger";
    }

    @PostMapping("/user")
    @ApiOperation("添加学生")
    public String user(User user){
        return user.getName()+":"+user.getAge();
    }

    @PostMapping("/user0")
    @ApiOperation("添加学生")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",value = "姓名"),
            @ApiImplicitParam(name = "age",value = "年龄",required = true)})
    public String user0(String name,Integer age){
        return name+":"+age;
    }

    @PostMapping("/user01")
    @ApiOperation("添加学生")
    public User user01(User user){
        return user;
    }

}
