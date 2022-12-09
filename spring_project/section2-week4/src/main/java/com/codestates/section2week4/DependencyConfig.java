package com.codestates.section2week4;

import com.codestates.section2week4.coffee.CoffeeRepository;
import com.codestates.section2week4.coffee.CoffeeService;
import com.codestates.section2week4.member.MemberRepository;
import com.codestates.section2week4.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class DependencyConfig {
}
