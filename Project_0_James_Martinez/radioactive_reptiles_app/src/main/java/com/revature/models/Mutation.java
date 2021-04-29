package com.revature.models;

public class Mutation extends Inventory{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String behavior;
	private String biome;
	private String mutationId;
	
	public Mutation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mutation(String name, String size, String description, float price, int stock, String behavior, String biome, String mutationId) {
		super(name, size, description, price, stock);
		this.behavior = behavior;
		this.biome = biome;
		this.mutationId = mutationId;
	}
	public String getBehavior() {
		return behavior;
	}
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	public String getBiome() {
		return biome;
	}
	public void setBiome(String biome) {
		this.biome = biome;
	}
	public String getMutationId() {
		return mutationId;
	}
	public void setMutationId(String mutationId) {
		this.mutationId = mutationId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((behavior == null) ? 0 : behavior.hashCode());
		result = prime * result + ((biome == null) ? 0 : biome.hashCode());
		result = prime * result + ((mutationId == null) ? 0 : mutationId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mutation other = (Mutation) obj;
		if (behavior == null) {
			if (other.behavior != null)
				return false;
		} else if (!behavior.equals(other.behavior))
			return false;
		if (biome == null) {
			if (other.biome != null)
				return false;
		} else if (!biome.equals(other.biome))
			return false;
		if (mutationId == null) {
			if (other.mutationId != null)
				return false;
		} else if (!mutationId.equals(other.mutationId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mutation [behavior=" + behavior + ", biome=" + biome + ", mutationId=" + mutationId + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
