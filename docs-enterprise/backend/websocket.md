# WebSocket

## Configuration

- Protocol: STOMP over SockJS
- Endpoint: `/ws`
- Application prefix: `/app`
- Broker prefixes: `/topic`, `/queue`

## Connection

```
ws://localhost:8080/ws
```

## Subscribe Topics

| Topic | Purpose |
|-------|---------|
| `/user/queue/notifications` | User notifications |
| `/topic/match/{matchId}` | PvP match updates |
| `/topic/ranking/update` | Leaderboard changes |

## Send Endpoints

| Endpoint | Purpose |
|---------|---------|
| `/app/pvp/join` | Join queue |
| `/app/pvp/submit` | Submit PvP code |

## Events

### PvP Match
```json
{
  "type": "MATCH_FOUND",
  "matchId": 123,
  "opponent": { "id": 456, "name": "Player2" }
}
```

### Notification
```json
{
  "type": "ACHIEVEMENT_UNLOCKED",
  "badge": { "name": "First Win" }
}
```