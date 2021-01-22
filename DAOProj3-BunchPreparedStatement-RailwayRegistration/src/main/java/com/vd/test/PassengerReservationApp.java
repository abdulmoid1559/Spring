package com.vd.test;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.vd.config.AppConfig;
import com.vd.dto.PassengerDTO;
import com.vd.service.RailwayReservationService;

public class PassengerReservationApp{
    public static void main( String[] args){
        Scanner scn=null;
        ApplicationContext ctx=null;
        List<PassengerDTO> listDTO=null;
        RailwayReservationService service=null;
        String status=null;
        String name=null;
        String gender=null;
        String srcPlace=null;
        String destPlace=null;
        float price=0.0f;
        int pno=0;
        
        scn=new Scanner(System.in);
        listDTO=new ArrayList<PassengerDTO>();
        System.out.println("PassengerReservationApp:: Enter Following Passenger Detail for reservation");
        System.out.println("....................................................................................................................");
        System.out.println("Enter journey starting place::");
        srcPlace=scn.next();
        System.out.println("Enter journey destination place::");
        destPlace=scn.next();
        System.out.println("number of passenger::");
        pno=scn.nextInt();
        
        
        for(int i=1;i<=pno;i++) {
        	PassengerDTO dto=new PassengerDTO();
        	System.out.println("enter "+i+" passenger name");
        	name=scn.next();
        	System.out.println("enter "+i+" passenger gender");
        	gender=scn.next();
        	System.out.println("enter "+i+" passenger price");
        	price=scn.nextFloat();
        	dto.setPassengerName(name);
        	dto.setGender(gender);
        	dto.setSrcPlace(srcPlace);
        	dto.setDestPlace(destPlace);
        	dto.setPrice(price);
        	listDTO.add(dto);
        }//for
        ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        service=ctx.getBean("resservice",RailwayReservationService.class);
        try {
			status=service.groupReservation(listDTO);
			System.out.println(status);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
        catch (Exception e) {
        	e.printStackTrace();
		}
        ((AbstractApplicationContext) ctx).close();
    }
}
