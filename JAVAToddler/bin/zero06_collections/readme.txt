1. JCF(Java Collection Framework)
  (서로 관련성을 가진 인스턴스화된 객체들을 관리하기위해 그룹화하고, 편리하게 활용할수있도록
   일관성있는 API를 제공하기위해 자바1.2부터 포함된 프레임웍)
  
  분류
      상속구조 1) interface Collection을 루트인터페이스로한 Set계열, List계열, Queue
          2) interface Map을 루트인터페이스로한 Map계열
      
      성능별 분류 기준 1) 저장 insert time - Vector 가장 빠름. HashMap과 HashTable이 가장 느림
               2) 검색 seek time - HashMap과 HashTable 가장 빠름
               3) 읽기 read time - ArrayList가 가장 빠름.
               
       
  구조 :             interface Collection                 interface Map
                            |                                  |
             ------------------------------                1) HashMap                  
             |              |             |                2) HashTable
            Set            List         Queue              3) TreeMap
             |
      1) HashSet          1) ArrayList    1) LinkedList  
      2) LinkedHashSet    2) Vector       2) PriorityQueue
      3) TreeSet 	      2).1 Stack      3) ArrayBlockingQueue
                                          4) LinkedBlockingQueue
                                          5) PriorityBlockingQueue

 특징 : Set계열 - null or 중복(저장객체의 hashCode 기준.) 저장 불가능. 
                      저장순서 관리하지않음.(단, LinkedHashSet은 저장순서를 관리함.)
      List계열 - null or 중복 저장 가능. 저장순서 관리함.
               Stack : LIFO(Last In First Out)
      Queue - FIFO(First In Last Out)         
      Map계열 - key/value Entry 패턴으로 저장되며 value값의 중복 가능. 
                      저장순서 관리하지 않음.
      
 올바른 JFC의 선택 기준 : 
	key/value 쌍으로 필요한가 value만 필요한가? 
		key	
			key/value 순서가 중요한가? 
				yes
					삽입 순서 혹은 key로 정렬이 필요한가? 
					삽입 순서 : LinkedHashMap
					key 정렬
						동기화가 필요한가? 
							yes : HashTable
							no : TreeMap
		        no
					'cache'를 써야하거나 만드는데 비싼 객체를 쓰는가? 
						yes : WeakHashMap
						no
						== 대신 equal()을 사용하기 위해 유일 key가 결정되어야하는가? 
							yes : HashMap
							no : IdentityHashMap
	
		value
			중복값이 포함될 것인가? 
				yes
					동기화가 필요한가? 
						yes
							선입후출(LIFO)의 인터페이스가 필요한가? 
								yes : Stack
								no : Vector
						no
							빠른 임의의 접근이 필요한가?
								yes : ArrayList
								no
									빠른 순차적 접근, 입력/삭제가 필요한가? 
										yes : LinkedList
										no 
											queue나 dequeue같은 인터페이스가 필요한가?
												yes
													빠른 속도의 queue가 필요한가? 
														yes : ArrayDeque
														no : LinkedList
												no : ArrayList
				no
					요소들의 순서가 중요한가?
						yes
							입력 순서나 값 정렬이 필요한가?
							입력 순서 : LinkedHashSet
							값 정렬 : TreeSet
						no : HashSet
      
컬렉션의 특징과 선언 및 활용
  - cache 구현(GeneralReference | WeakReference | SoftReference)
  - fail-fast test
    (A스레드가 공유자원에 접근 후 작업 중 B스레드에 실행 제어권이 넘어간 후 A스레드가 작업중이던
       자원을 B스레드가 수정할때 A스레드는 이후 제어권을 넘겨 받은 후 수정된 공유자원으로 작업을 진행하게되므로
       동기화가 보장되지 못함.) 
  - 다중 스레드 환경에서의 컬렉션 객체 접근시의 컬렉션 동기화
      수동 동기화시 활용
    java.util.Collections의 활용

  