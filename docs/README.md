# DevArena - The New Way to Learn Programming

<div align="center">

![DevArena Logo](https://via.placeholder.com/150x150/devarena?text=DevArena)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub Stars](https://img.shields.io/github/stars/lkznx7/devarena)](https://github.com/lkznx7/devarena/stargazers)
[![GitHub Forks](https://img.shields.io/github/forks/lkznx7/devarena)](https://github.com/lkznx7/devarena/network)
[![Contributors](https://img.shields.io/github/contributors/lkznx7/devarena)](https://github.com/lkznx7/devarena/contributors)

**A gamified learning platform for programmers. The perfect mix of Duolingo + LeetCode + Discord + RPG.**

</div>

---

## 🎮 What is DevArena?

DevArena is an innovative gamified learning platform designed to make programming education engaging, fun, and effective. It combines the best elements from successful platforms:

- **Duolingo** - Gamified learning with streaks, rewards, and progression
- **LeetCode** - Technical challenges and coding exercises
- **Discord** - Community interaction and social features
- **RPG** - Character progression, levels, and achievements

### ✨ Key Features

- 🏆 **Ranked PvP Arena** - Compete against other developers in real-time coding battles
- 📚 **Structured Challenges** - Progressive difficulty levels from beginner to expert
- 🤖 **AI Mentor** - Intelligent guidance powered by Groq API
- 🎯 **Missions & Quests** - Daily and weekly challenges to keep you motivated
- 🏅 **XP & Leveling System** - Earn experience points and unlock new abilities
- 💬 **Real-time Notifications** - WebSocket-powered instant updates
- 👥 **Social Features** - Friends, clans, and community discussions

---

## 🛠️ Tech Stack

### Frontend
- **Next.js 15** - React framework with App Router
- **TypeScript** - Type-safe development
- **TailwindCSS** - Utility-first CSS framework
- **Shadcn/UI** - Modern UI components
- **Framer Motion** - Smooth animations
- **Zustand** - Lightweight state management
- **TanStack Query** - Server state management

### Backend
- **Java 21** - Latest LTS Java version
- **Spring Boot 3.3** - Modern Java framework
- **Spring Security** - Robust authentication/authorization
- **JWT** - Secure token-based auth
- **WebSocket** - Real-time communication
- **PostgreSQL** - Primary database
- **Redis** - Caching and session management

### Infrastructure
- **Docker** - Containerization
- **Docker Compose** - Multi-container orchestration
- **Nginx** - Reverse proxy and load balancing

### External APIs
- **Piston API** - Code execution engine
- **Groq API** - AI-powered code assistance

---

## 📁 Project Structure

```
devarena/
├── frontend/          # Next.js application
├── backend/          # Spring Boot application
├── docker/           # Docker configurations
└── docs/             # Documentation
```

---

## 🚀 Quick Start

### Prerequisites
- Node.js 18+
- Java 21
- Docker & Docker Compose
- PostgreSQL 15+
- Redis 7+

### Local Development

```bash
# Clone the repository
git clone https://github.com/lkznx7/devarena.git
cd devarena

# Start with Docker Compose
docker-compose up -d

# Or run individually:
# Backend: cd backend && ./mvnw spring-boot:run
# Frontend: cd frontend && npm run dev
```

---

## 📚 Documentation

- [Architecture Overview](./docs/architecture.md)
- [API Documentation](./docs/api/README.md)
- [Contributing Guide](./CONTRIBUTING.md)
- [Code of Conduct](./CODE_OF_CONDUCT.md)

---

## 🤝 Contributing

We welcome contributions! Please read our [contributing guidelines](CONTRIBUTING.md) before getting started.

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🌟 Show Your Support

Give a ⭐️ if this project helped you!

---

<div align="center">

**Built with ❤️ by developers, for developers**

</div>