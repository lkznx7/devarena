# Performance

## Optimizations

### Code Splitting
- Route-based splitting
- Automatic chunks

### Server Components
- Static prerendering
- Reduced client bundle

### Caching
- TanStack Query cache
- Stale-while-revalidate

### CSS
- TailwindCSS purge
- Minimal bundle size

## Targets

| Metric | Target |
|--------|--------|
| First Contentful Paint | <1.5s |
| Time to Interactive | <3s |
| Bundle size | <200KB gzipped |

## Best Practices

- Use Server Components when possible
- Lazy load heavy components
- Optimize images
- Use proper caching headers