/*
 * package com.tingyu.employee.test;
 * 
 * import java.util.List;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.mock.web.MockHttpServletRequest; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner; import
 * org.springframework.test.context.web.WebAppConfiguration; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders; import
 * org.springframework.util.LinkedMultiValueMap; import
 * org.springframework.util.MultiValueMap; import
 * org.springframework.web.context.WebApplicationContext;
 * 
 * import com.github.pagehelper.PageInfo; import
 * com.tingyu.employee.pojo.Employee;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @WebAppConfiguration
 * 
 * @ContextConfiguration( locations= {"classpath:applicationContext.xml",
 * "classpath:springmvc.config.xml"}) public class MvcTest {
 * 
 * @Autowired WebApplicationContext context; MockMvc mockMvc;
 * 
 * @Before public void initMockMvc() {
 * mockMvc=MockMvcBuilders.webAppContextSetup(context).build(); }
 * 
 * @Test public void getEmp() throws Exception { MultiValueMap<String, String>
 * params=new LinkedMultiValueMap<String, String>(); params.add("pageNum", "1");
 * params.add("pageSize","10");
 * 
 * MvcResult result=
 * mockMvc.perform(MockMvcRequestBuilders.get("/emp/list").params(params)).
 * andReturn(); MockHttpServletRequest request=result.getRequest();
 * 
 * PageInfo pageInfo=(PageInfo)request.getAttribute("PageInfo");
 * 
 * System.out.print(pageInfo.getTotal()); List<Employee>
 * emps=pageInfo.getList(); for(Employee emp:emps) { System.out.println(emp); }
 * 
 * 
 * } }
 */