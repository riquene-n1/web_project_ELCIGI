package kr.ac.kopo.member.vo;

public class MemberVO {

    private String id;
    private String password;
    private String name;
    private String type;
    private String nickname;
    private int age;
    private String gender;
    private double height;
    private double weight;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

    public MemberVO(String id, String password, String name, String type, String nickname,
                    int age, String gender, double height, double weight) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.type = type;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getNickname() {
                return nickname;
        }

        public void setNickname(String nickname) {
                this.nickname = nickname;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public double getHeight() {
                return height;
        }

        public void setHeight(double height) {
                this.height = height;
        }

        public double getWeight() {
                return weight;
        }

        public void setWeight(double weight) {
                this.weight = weight;
        }

        @Override
        public String toString() {
                return "MemberVO [id=" + id + ", password=" + password + ", name=" + name
                                + ", type=" + type + ", nickname=" + nickname + ", age=" + age
                                + ", gender=" + gender + ", height=" + height + ", weight=" + weight + "]";
        }
	
	
}
