package br.com.soapboxrace.jpa;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "LOBBY")
public class LobbyEntity implements ISoapBoxEntity {

	private static final long serialVersionUID = -7685436026786063561L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

	protected boolean isInviteEnabled = false;

	@ManyToOne
	@JoinColumn(name = "EVENTID", referencedColumnName = "EVENTID")
	private EventDefinitionEntity event;

	private boolean isWaiting = false;

	@Transient
	private long lobbyCountdownInMilliseconds = 60000;

	@Transient
	private long lobbyStuckDurationInMilliseconds = 5000;

	@XmlTransient
	@OneToMany(mappedBy = "lobby", targetEntity = LobbyEntrantEntity.class, cascade = CascadeType.MERGE)
	private List<LobbyEntrantEntity> entrants;

	@XmlTransient
	private Date lobbyDateTimeStart = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public long getLobbyStuckDurationInMilliseconds() {
		return lobbyStuckDurationInMilliseconds;
	}

	public void setLobbyStuckDurationInMilliseconds(long lobbyStuckDurationInMilliseconds) {
		this.lobbyStuckDurationInMilliseconds = lobbyStuckDurationInMilliseconds;
	}

	public long getLobbyCountdownInMilliseconds() {
		if (lobbyDateTimeStart != null) {
			Date now = new Date();
			Long time = now.getTime() - lobbyDateTimeStart.getTime();
			time = 60000L - time;
			return time;
		}
		return lobbyCountdownInMilliseconds;
	}

	public void setLobbyCountdownInMilliseconds(long lobbyCountdownInMilliseconds) {
		this.lobbyCountdownInMilliseconds = lobbyCountdownInMilliseconds;
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

	public Date getLobbyDateTimeStart() {
		return lobbyDateTimeStart;
	}

	public void setLobbyDateTimeStart(Date lobbyDateTimeStart) {
		this.lobbyDateTimeStart = lobbyDateTimeStart;
	}

}
