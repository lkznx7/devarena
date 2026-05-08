# Backend Modules

## Module Overview

| Module | Purpose | Endpoints |
|--------|---------|-----------|
| Auth | JWT + OAuth authentication | 4 |
| User | Profile, stats, followers | 6 |
| Challenge | Topics, challenges, hints | 3 |
| Submission | Code execution & validation | 4 |
| Mission | Daily/weekly missions | 2 |
| Badge | Achievements system | 2 |
| Ranking | Leaderboards | 3 |
| PvP | Real-time battles | 4 |
| Notification | Real-time notifications | 4 |
| AI | Groq-powered assistant | 1 |

## Module Details

### Auth Module
- JWT token generation/validation
- OAuth2 (Google, GitHub)
- Refresh token rotation

### User Module
- Profile management
- XP system (awardXp)
- Streak tracking
- Follow system

### Challenge Module
- Topic CRUD
- Challenge CRUD with test cases
- Progressive hints

### Submission Module
- Piston API integration
- Code execution with timeout (10s)
- Test case validation

### Mission Module
- Daily/weekly mission assignment
- Progress tracking
- Auto-reset jobs

### Badge Module
- Achievement definitions
- Automatic evaluation on events

### Ranking Module
- Global/weekly/monthly rankings
- PvP rankings
- Scheduled snapshots

### PvP Module
- Matchmaking queue
- Real-time matches (WebSocket)
- MMR calculation

### Notification Module
- Real-time via WebSocket
- Read/unread tracking

### AI Module
- Groq API integration
- Hint generation
- Code review
- Error explanation

## Configuration Files

| File | Purpose |
|------|---------|
| SecurityConfig | Spring Security |
| WebSocketConfig | STOMP WebSocket |
| CorsConfig | Cross-origin |
| JwtTokenProvider | JWT handling |