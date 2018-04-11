package com.rong.ssi.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.rong.ssi.quartz.service.CommonJobServiceInter;
import com.rong.ssi.quartz.serviceImpl.CommonJobServiceImpl;

/**      
 * @author »›≈‡Ìµ      
 * QuartzJobBean ¿‡   
 */ 

public class RunMeJob extends QuartzJobBean {
	  private RunMeTask runMeTask;
	    public void setRunMeTask(RunMeTask runMeTask) {
	        this.runMeTask = runMeTask;
	    }
	    CommonJobServiceImpl commonJobServiceImpl;
		CommonJobServiceInter commonJobServiceInter;
		
	    public void setCommonJobServiceImpl(CommonJobServiceImpl commonJobServiceImpl) {
			this.commonJobServiceImpl = commonJobServiceImpl;
		}

		public void setCommonJobServiceInter(CommonJobServiceInter commonJobServiceInter) {
			this.commonJobServiceInter = commonJobServiceInter;
		}

		protected void executeInternal(JobExecutionContext context)
	        throws JobExecutionException {

	        runMeTask.printMe();
	       // commonJobServiceImpl.quartzJob();
	    }
}
