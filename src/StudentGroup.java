import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
		//return null;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		int x=0;
		
			if(students==null)
			{
				throw new IllegalArgumentException();
			}
			else
			{
				for(Student s:students)
				{
					this.students[x]=s;
			}
			}
		}
		/*catch(IllegalArgumentException e)
		{
			System.out.println("error");
			e.printStackTrace();
		}*/
	

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
	
			if(index<0 ||index>=students.length)
			{
				throw new IllegalArgumentException("length is not varied");
			}
			
				
		/*
		catch(IllegalArgumentException e)
		{
			System.out.println("over length");
			e.printStackTrace();
		}*/
		return students[index];
			
//		}
		
		//return null;
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		
			if(student==null || index<0 || index>=students.length)
			{
				throw new IllegalArgumentException("length is not varied");
			}
			else
			{
				for(Student st:students)
				{
					this.students[index]=st;
				}
			}
		/*
		catch(IllegalArgumentException e)
		{
			System.out.println("error");
			e.printStackTrace();
		}*/
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
			
		}
		add(student,0);
		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		add(student,students.length-1);
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
	
			if(student==null || index<0 || index>=students.length)
			{
				throw new  IllegalArgumentException();
			}
			
			 Student[] s=new Student[students.length+1];
			for(int i=0;i<index;i++)
				s[i]=students[i];
			
			s[index]=student;
			for(int i=index+1;i<students.length;i++)
				s[i]=students[i];
			students=null;
			setStudents(s);
				
		}
	

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		Student[] stud = new Student[students.length-1];
		for(int i=0;i<index;i++)
			stud[i]=students[i];
		for(int i=index+1;i<students.length;i++)
			stud[i]=students[i];
		students=null;
		setStudents(stud);
		
	}
	

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		Student[] s=new Student[students.length-1];
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				remove(i);
			}
		}
		students=null;
		setStudents(s);
		
		
	}

	@Override
	public void removeFromIndex(int index) {
		
		// Add your implementation here
		if(index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		Student[] stud = new Student[students.length-1];
		for(int i=0;i<index;i++)
			stud[i]=students[i];
		students=null;
		setStudents(stud);
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		Student[] s=new Student[students.length-1];
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				removeFromIndex(i+1);
			}
		}
		students=null;
		setStudents(s);
		
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		Student[] s=new Student[students.length-1];
		for(int i=index;i<students.length;i++)
		{
			s[i]=students[i];
		}
		students=null;
		setStudents(s);
		
		
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		Student[] s=new Student[students.length-1];
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				for(int j=i;i<students.length;i++)
				{
					s[i]=students[i];
				}
			}
		}
		students=null;
		setStudents(s);
		
		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		
		int i,j;
		Student [] s=new Student[students.length-1];
		for(i=0;i<students.length-1;i++)
		{
			for(j=0;j<students.length-i-1;i++)
			{
				if(students[j].compareTo(students[j+1])>0)
				{
					Student temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
			}
		}
	}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null){
			throw new IllegalArgumentException();
		}
		Student []s=new Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().equals(date) || students[i].getBirthDate().before(date)){
				s[i]=students[i];
			}
		}
		
		return s;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate==null||lastDate==null)
		throw new IllegalArgumentException();
		int count=0;
		Student []s=new Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			if((students[i].getBirthDate().after(firstDate))&&(students[i].getBirthDate().before(firstDate))
					||students[i].getBirthDate().equals(firstDate)||students[i].getBirthDate().equals(lastDate))
			{
				s[count]=students[i];
				count++;
			}
		}
		
		return s;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
