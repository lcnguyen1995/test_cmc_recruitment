package com.cmc.recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmc.recruitment.entity.Department;
import com.cmc.recruitment.entity.Position;
import com.cmc.recruitment.entity.Request;
import com.cmc.recruitment.entity.RequestStatus;
import com.cmc.recruitment.entity.Skill;
import com.cmc.recruitment.entity.User;
import com.cmc.recruitment.repository.DepartmentRepository;
import com.cmc.recruitment.repository.PositionRepository;
import com.cmc.recruitment.repository.RequestRepository;
import com.cmc.recruitment.repository.RequestStatusRepository;
import com.cmc.recruitment.repository.SkillRepository;
import com.cmc.recruitment.repository.UserRepository;

@Controller
public class MainController {

  @Autowired
  private PositionRepository positionRepository;
  @Autowired
  private RequestStatusRepository rsp;
  @Autowired
  private SkillRepository sp;
  @Autowired
  private DepartmentRepository dp;
  @Autowired
  private RequestRepository rp;
  @Autowired
  UserRepository userRes;
  
  @GetMapping("/")
  public String index(Model model) {
    List<Position> listPosition = (List<Position>) positionRepository.findAll();
    System.out.println(listPosition);
    for (Position p : listPosition) System.out.println(p);
    
    List<RequestStatus> listRequestStatus = (List<RequestStatus>) rsp.findAll();
    for (RequestStatus rs : listRequestStatus) System.out.println(rs);
    
    List<Skill> listSkill = (List<Skill>) sp.findAll();
    for (Skill skill : listSkill) System.out.println(skill);
    
    List<Department> listDepartment = (List<Department>) dp.findAll();
    for (Department department : listDepartment) System.out.println(department);
    
    List<Request> listRequest = (List<Request>) rp.findAll();
    for (Request request : listRequest) System.out.println(request.getSkillCollection());
    
    List<User> listUser = (List<User>) userRes.findAll();
    System.out.println("get role of user");
    for (User user : listUser) System.out.println(user.getRoleCollection());
    return "index";
  }
  
}
