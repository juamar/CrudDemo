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
import model.pojos.Curso;
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
public class CursoController
{    
    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    public ModelAndView cursos(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        
        ModelAndView mv = new ModelAndView("/cursos");
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
            mv.addObject("message", "hello");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return mv;
    }
    
    @RequestMapping(value = "/newCurso", method = RequestMethod.GET)
    public ModelAndView newCurso()
    {
        //return "newCurso";
        return new ModelAndView("/newCurso", "curso", new Curso());
    }
    
    @RequestMapping(value = "/cursos/addCurso", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("curso")Curso c, 
      BindingResult result, ModelMap model,
      HttpServletRequest request, HttpServletResponse response)  {
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        Curso curso = new Curso();
        curso.setNombre(c.getNombre());

        session.save(curso);
        
        tx.commit();
        session.close();
        
        return new ModelAndView("redirect:/cursos");
    }
}
