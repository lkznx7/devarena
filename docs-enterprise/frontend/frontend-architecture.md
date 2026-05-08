# Frontend Architecture

## Project Overview

| Property | Value |
|----------|-------|
| Framework | Next.js 15 |
| Language | TypeScript 5 |
| Styling | TailwindCSS v4 |
| UI Library | shadcn/ui (Radix) |

## Directory Structure

```
src/
├── app/                    # App Router pages
│   ├── auth/              # Login, Register
│   ├── dashboard/         # Protected routes
│   └── public/            # Landing page
├── components/
│   ├── ui/                # shadcn components
│   ├── layout/           # Navbar, Sidebar
│   ├── forms/            # Form components
│   └── shared/           # Shared UI
├── hooks/                 # Custom hooks
├── lib/                   # Utilities
├── services/              # API services
├── stores/                # Zustand stores
├── providers/             # React providers
├── types/                 # TypeScript types
└── constants/             # App constants
```

## Component Count

| Category | Count |
|----------|-------|
| UI Components | 18 |
| Layout Components | 3 |
| Forms Components | 3 |
| Pages | 9 |
| Services | 6 |

## Routes

### Public
- `/` → Redirect
- `/public` → Landing
- `/auth/login` → Login
- `/auth/register` → Register

### Protected (Require Auth)
- `/dashboard` → Dashboard
- `/dashboard/profile` → Profile
- `/dashboard/settings` → Settings
- `/dashboard/chat` → Chat
- `/dashboard/users` → Users

## Commands

```bash
npm run dev     # Development
npm run build   # Production build
npm run start  # Production server
npm run lint   # ESLint
```