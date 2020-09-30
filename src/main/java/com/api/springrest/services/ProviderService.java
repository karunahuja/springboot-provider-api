package com.api.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.springrest.dao.ProviderRepository;
import com.api.springrest.entities.Provider;


@Component
public class ProviderService {

	
	
	@Autowired
	private ProviderRepository providerRepository;
	
//	private static List<Provider> list=new ArrayList<>();
//	
//	static {
//		
//		
//		list.add(new Provider(12,"Java Complete","XYZ"));
//		
//		list.add(new Provider(13,"python","ABC"));
//		
//		
//		list.add(new Provider(14,"Java not  Complete","XYsZ"));
//		
//		list.add(new Provider(15,"pythons","AaBC"));
//		
//		
//		
//	}

	public List<Provider> getAllProviders() {
		
		List<Provider> list= (List<Provider>) this.providerRepository.findAll();
		return list;
		
	}
	
	
	public Optional<Provider> getProviderById(int id) {
		Optional<Provider> provider=null;
		try {
		//provider=list.stream().filter(e->e.getId()==id).findFirst().get();
		
				provider=this.providerRepository.findById(id);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return provider;
	}


//	public static void setList(List<Provider> list) {
//		ProviderService.list = list;
//	}
//	
	
	
	public Provider addProvider(Provider b) {
		
		Provider result=providerRepository.save(b);
		
		return result;
		
	}
	
	public void deleteProvider(int bid) {
		// TODO Auto-generated method stub

         //Provider provider=null;
		
		//provider=list.stream().filter(e->e.getId()==bid).findFirst().get();
		
         providerRepository.deleteById(bid);
		 //list.remove(provider);
		 
		 
}

	
	public void updateProvider(Provider provider,int providerId)
	{
		
//		list=list.stream().map(b->{
//			
//			if(b.getId()==providerId) {
//				b.setTitle(provider.getTitle());
//				b.setAuthor(provider.getAuthor());
//				
//			}
//			
//			return b;
//		}).collect(Collectors.toList());
//		
//		
		provider.setId(providerId);
		providerRepository.save(provider);
		
		
	}
	
}
