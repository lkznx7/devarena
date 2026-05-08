# State Management

## Client State (Zustand)

### Auth Store
```typescript
interface AuthState {
  user: User | null;
  isAuthenticated: boolean;
  isLoading: boolean;
  setUser: (user: User | null) => void;
  setLoading: (loading: boolean) => void;
  login: (user, accessToken, refreshToken) => void;
  logout: () => void;
}
```

### UI Store
```typescript
interface UIState {
  sidebarCollapsed: boolean;
  sidebarMobileOpen: boolean;
  toggleSidebar: () => void;
  toggleMobileSidebar: () => void;
  closeMobileSidebar: () => void;
}
```

## Server State (TanStack Query)

### Default Config
- staleTime: 60s
- refetchOnWindowFocus: false
- retry: 1

### Usage
```typescript
const { data, isLoading } = useQuery({
  queryKey: ['user', userId],
  queryFn: () => fetchUser(userId)
});
```

## Persistence

- Auth tokens: localStorage
- Theme: next-themes (prefers localStorage)

## Auth Flow

1. Login → Store tokens in localStorage
2. Set user state in Zustand
3. Redirect to dashboard
4. Axios interceptor adds Bearer token
5. 401 triggers refresh or logout