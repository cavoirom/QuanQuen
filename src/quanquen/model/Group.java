package quanquen.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Group implements Serializable {
	private String name = "";
	private LinkedHashSet<Member> members;
	private LinkedHashSet<String> permissions;

	public Group() {
		members = new LinkedHashSet<Member>();
		permissions = new LinkedHashSet<String>();
	}

	public Group(String name) {
		members = new LinkedHashSet<Member>();
		permissions = new LinkedHashSet<String>();
		this.name = name;
	}

	public Group(String name, LinkedHashSet<Member> members,
			LinkedHashSet<String> permissions) {
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
		return (members == null) ? new LinkedHashSet<Member>() : members;
	}

	public void setMembers(LinkedHashSet<Member> members) {
		this.members = members;
	}

	public void addMember(Member member) {
		this.members.add(member);
	}

	public LinkedHashSet<String> getPermissions() {
		return (permissions == null) ? new LinkedHashSet<String>()
				: permissions;
	}

	public void setPermissions(LinkedHashSet<String> permissions) {
		this.permissions = permissions;
	}
}
