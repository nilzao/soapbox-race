package br.com.soapboxrace.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOBBY")
public class LobbyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7685436026786063561L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;

	protected boolean isInviteEnabled = false;

	@ManyToOne
	@JoinColumn(name = "EVENTID", referencedColumnName = "EVENTID")
	private EventDefinitionEntity event;

	private boolean isWaiting = false;

	private int lobbyCountdownInMilliseconds = 10000;

	private int lobbyStuckDurationInMilliseconds = 2000;

	@OneToMany(mappedBy = "lobby", targetEntity = LobbyEntrantEntity.class, cascade = CascadeType.MERGE)
	private List<LobbyEntrantEntity> entrants;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isInviteEnabled() {
		return isInviteEnabled;
	}

	public void setInviteEnabled(boolean isInviteEnabled) {
		this.isInviteEnabled = isInviteEnabled;
	}

	public EventDefinitionEntity getEvent() {
		return event;
	}

	public void setEvent(EventDefinitionEntity event) {
		this.event = event;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	public void setWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting;
	}

	public int getLobbyCountdownInMilliseconds() {
		return lobbyCountdownInMilliseconds;
	}

	public void setLobbyCountdownInMilliseconds(int lobbyCountdownInMilliseconds) {
		this.lobbyCountdownInMilliseconds = lobbyCountdownInMilliseconds;
	}

	public int getLobbyStuckDurationInMilliseconds() {
		return lobbyStuckDurationInMilliseconds;
	}

	public void setLobbyStuckDurationInMilliseconds(int lobbyStuckDurationInMilliseconds) {
		this.lobbyStuckDurationInMilliseconds = lobbyStuckDurationInMilliseconds;
	}

	public List<LobbyEntrantEntity> getEntrants() {
		return entrants;
	}

	public void setEntrants(List<LobbyEntrantEntity> entrants) {
		this.entrants = entrants;
	}

	public boolean add(LobbyEntrantEntity e) {
		if (this.entrants == null) {
			this.entrants = new ArrayList<LobbyEntrantEntity>();
		}
		return entrants.add(e);
	}

}
