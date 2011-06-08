package pl.studioit.puzzlecrm.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Cacheable(true)
@Entity
@Table(name = "category")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "name")
	@NotNull(message = "Pole nie może być puste!")
    private String name;
	
	@OneToMany(mappedBy = "parent", cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	//@JoinColumn(name = "parent") 
	//@OrderColumn
	private List<Category> children = new LinkedList<Category>(); 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "parent")
	private Category parent;
	
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Category> children) {
		this.children = children;
	}

	/**
	 * @return the children
	 */
	public List<Category> getChildren() {
		return children;
	}
	
	public Category getParent() {
	return parent;
	}
	
	public void setParent(Category parent) {
		this.parent = parent;
	}
	
	public Category() {
		
	}

	public Category(Long id, String name, Category parent) {
 
		this.id = id;
		this.name = name;
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name+"]";
	}

	


	
	
}
