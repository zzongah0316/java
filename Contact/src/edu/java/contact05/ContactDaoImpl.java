package edu.java.contact05;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.java.contact.fileutil.FileUtil;
import edu.java.contact.model.Contact;

// MVC(Model-view-Controller) 아키텍쳐에서 컨트롤러 구현 클래스.
// singleton 디자인 패턴을 적용.

public class ContactDaoImpl implements ContactDao {
	// singleton step 1
	private static ContactDaoImpl instance = null;
	
	// singleton step 2
	private ContactDaoImpl() {
		dataDir = FileUtil.initDataDir(); // 데이터 폴더 초기화
		dataFile = new File(FileUtil.DATA_DIR, FileUtil.DATA_FILE);
		contacts = FileUtil.initData(); // 데이터 초기화 - 파일의 내용을 메모리에 로딩.
	};
	// TODO: ContactDaoImpl에는 연락처 데이터를 변경하는 메서드들(연락처 추가, 수정, 삭제)이 있음.
	// -> 연락처 데이터가 변경되는 메서드에서 FileUtil.writeDataToFile() 메서드 호출.
	
	// singleton step 3
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	// fields
	private List<Contact> contacts ;
	private File dataDir; // 연락처 데이터 파일을 저장할 폴더
	private File dataFile; // 연락처 데이터 파일
	
	// methods
	
	/**
	 * 어떤 인덱스가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인 지를 리턴.
	 * @param index 유효한 인덱스인 지 검사할 인덱스/
	 * @return 사용가능한 인덱스는 true, 그렇지 않으면 false.
	 */
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}

	// CRUD(Create, Read, Update, Delete) 기능 메서드들:
	@Override
	public int create(Contact c) {
			contacts.add(c); // (heap)메모리에 있는 List에 연락처를 추가(file에 추가X)
			FileUtil.writeDataToFile(contacts, dataFile);
			
			return 1;
		} 

	@Override
	public List<Contact> read() {
		
//		List<Contact> contacts2 = new ArrayList<>();
//		// -> contacts 배열에 저장된 원소 개수의 크기를 갖는 새로운 배열을 생성.
//		for(int i = 0; i<contacts.size(); i++) {
//		    contacts2.get(i) = contacts.get(i);
//		}
		return contacts;
	}
		
	// 내가 푼것	
//	List<Contact> contacts2 = new ArrayList<>();
//	Iterator<Contact> itr = contacts.iterator();
//	while (itr.hasNext()){
//		Contact s = itr.next();
//		contacts2.add(s);
//	} return contacts2;
//	}
		
		// 선생님 푼것
//		return FileUtil.readDataFromFile(dataFile);
//	}
	


	@Override
	public Contact read(int index) {
		if(isValidIndex(index)) {
			List<Contact> list = FileUtil.readDataFromFile(dataFile);
			return list.get(index);
//			return contacts;
		} else {
		return null;
	    }
	}

	
	@Override
	public int update(int index, Contact contact) {
		if(isValidIndex(index)) { // 유효한 인덱스이면
			// 내가 푼것
//			contacts.get(index).setName(contact.getName());
//			contacts.get(index).setPhone(contact.getPhone());
//			contacts.get(index).setEmail(contact.getEmail());
			// contacts[index] = contact;
			
			// 선생님 푼것
			contacts.set(index, contact);  // heap 메모리의 List 객체가 변경
			FileUtil.writeDataToFile(contacts, dataFile); // 변경된 리스트를 파일에 저장.
			return 1;
		} else { // 유효하지 않은 인덱스이면
			return 0; 
		}
		
	}

	@Override
	public int delete(int index) {
		 if (!isValidIndex(index)) {
	            return 0;
	        }
	        
	        contacts.remove(index); // / heap 메모리의 List가 변경
	        FileUtil.writeDataToFile(contacts, dataFile); // 변경된 내용을 파일에 저장.
	        
	        return 1;
	    }
}
