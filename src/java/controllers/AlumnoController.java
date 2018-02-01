/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import model.pojos.*;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JuanIgnacio
 */
@Controller
public class AlumnoController
{    
    @RequestMapping(value = "/alumnos", method = RequestMethod.GET)
    public ModelAndView alumnos() throws Exception
    {
        ModelAndView mv = new ModelAndView("/alumnos/alumnos");
        List<Alumno> a = null;
        
        try
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String hql = "from Alumno";
            Query query = session.createQuery(hql);
            a =  query.list();
            
            //Más consultas para evitar el lazy false y el problema de performance que conlleva.
            /*
            Y haremos algo como:
            
            a.setCurso(c); //c será una isntancia de curso que me traje de una de las supuestas consultas de arriba.
            */
            
            tx.commit();
            session.close();
            
            mv.addObject("alumnos",a);
            mv.addObject("message", "Alumnos");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return mv;
    }
    
    @RequestMapping(value = "/alumnos/newAlumno", method = RequestMethod.GET)
    public ModelAndView newAlumno()
    {
        ModelAndView mv = new ModelAndView("/alumnos/newAlumno", "alumno", new Alumno());
        
        List<Curso> c = null;
        
        try
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String hql = "from Curso";
            Query query = session.createQuery(hql);
            c =  query.list();
            
            tx.commit();
            session.close();
            
            mv.addObject("cursos",c);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return mv;
    }
    
    @RequestMapping(value = "/alumnos/addAlumno", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("alumno")Alumno a, 
      BindingResult result, ModelMap model)  {
        //System.out.println(a.getCurso().getId() + "," + a.getNombres());
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        Alumno alumno = new Alumno();
        alumno.setNombres(a.getNombres());
        alumno.setApellidos(a.getApellidos());
        alumno.setCurso(a.getCurso());

        session.save(alumno);
        
        tx.commit();
        session.close();
        
        return new ModelAndView("redirect:/alumnos");
    }
}
