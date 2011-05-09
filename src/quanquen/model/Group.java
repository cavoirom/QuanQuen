package quanquen.model;

import java.util.LinkedHashSet;

public class Group {
	private String name;
	private LinkedHashSet<Member> members;
	private LinkedHashSet<String> permissions;
	
	public Group (String name, LinkedHashSet<Member> members, LinkedHashSet<String> permissions) {
		this.name = name;
		this.members = members;
		this.permissions = permissions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedHashSet<Member> getMembers() {
		return members;
	}

	public void setMembers(LinkedHashSet<Member> members) {
		this.members = members;
	}
	
	public void addMember(Member member) {
		this.members.add(member);
	}

	public LinkedHashSet<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(LinkedHashSet<String> permissions) {
		this.permissions = permissions;
	}
}
