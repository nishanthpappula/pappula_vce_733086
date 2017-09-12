import java.util.Arrays;
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
		return this.students;
		// Add your implementation here
		
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(index<0||index>=students.length||student==null)
			throw new IllegalArgumentException();
		this.students[index]=student;
		
		
	}

	@Override
	public void addFirst(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		this.students= Arrays.copyOf(this.students, this.students.length + 1);
		for(int i=1;i<this.students.length;i++)
			students[i]=students[i-1];
		students[0]=student;
		// Add your implementation here
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		this.students= Arrays.copyOf(this.students, this.students.length + 1);
		int n=this.students.length;
		students[n-1]=student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(index<0||index>=students.length||student==null)
			throw new IllegalArgumentException();
		this.students= Arrays.copyOf(this.students, this.students.length + 1);
		for(int i=this.students.length-1;i>index;i++)
			students[i]=students[i-1];
		students[index]=student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		for(int i=index;i<this.students.length-1;i++)
			students[i]=students[i+1];
		int n=this.students.length-1;
		this.students= Arrays.copyOfRange(this.students, 0,n );
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		int j=0;
		for(int i=0;i<this.students.length-1;i++)
			if(this.students[i].equals(student))
			{
				j=i;
				break;
			}
		if(j==0)
			throw new IllegalArgumentException();
		for(int i=j;i<this.students.length-1;i++)
			students[i]=students[i+1];
		int n=this.students.length;
		this.students= Arrays.copyOfRange(this.students, 0,n );
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		this.students= Arrays.copyOfRange(this.students, 0,index+1 );
	}

	@Override
	public void removeFromElement(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		int j=0;
		for(int i=0;i<this.students.length-1;i++)
			if(this.students[i].equals(student))
			{
				j=i;
				break;
			}
		if(j==0)
			throw new IllegalArgumentException();
		this.students= Arrays.copyOfRange(this.students, 0,j+1 );
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		int n=this.students.length;
		this.students= Arrays.copyOfRange(this.students, index,n );
		
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		int j=0;
		for(int i=0;i<this.students.length-1;i++)
			if(this.students[i].equals(student))
			{
				j=i;
				break;
			}
		if(j==0)
			throw new IllegalArgumentException();
		int n=this.students.length;
		this.students= Arrays.copyOfRange(this.students, j,n );
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int n=this.students.length;
	   for(int i=0;i<n-1;i++)
	   {
		   for(int j=0;j<n-i-1;j++)
		   {
			   if(students[j].compareTo(students[j+1])<0)
			   {
				   Student s=this.students[i];
				   this.students[i]=this.students[j];
				   this.students[j]=s;
			   }
		   }
	   }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		Student[] s=new Student[this.students.length-1];
		int j=0;
		for(int i=0;i<this.students.length-1;i++)
		{
			Date d=students[i].getBirthDate();
			if(d.compareTo(date)<0)
				{
				s[j]=students[i];
				j++;
				}
		}
		s=Arrays.copyOfRange(s, 0,j );
		return s;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
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
