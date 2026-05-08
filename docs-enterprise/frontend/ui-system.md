# UI System

## Components (shadcn/ui)

| Component | Variants | Notes |
|-----------|----------|-------|
| Button | default, destructive, outline, secondary, ghost, link | Sizes: sm, default, lg, icon |
| Card | default, elevated, outline, ghost | Header, content, footer |
| Input | text, password, email | With label support |
| Dialog | modal with overlay | Close button, header/footer |
| DropdownMenu | context menu | Trigger, content, items |
| Tabs | horizontal | List, trigger, content |
| Avatar | with fallback | Initials support |
| Badge | status tags | Multiple styles |
| Tooltip | hover info | Configurable delay |

## Form System

Integration: React Hook Form + Zod

```typescript
<Form>
  <FormField name="email">
    <FormLabel>Email</FormLabel>
    <FormControl>
      <FormInput />
    </FormControl>
    <FormMessage />
  </FormField>
</Form>
```

## Theming

CSS Variables (OKLCH color space):

### Light Mode
- background: oklch(0.985...)
- foreground: oklch(0.144...)
- primary: oklch(0.546...)
- border: oklch(0.92...)

### Dark Mode
- background: oklch(0.144...)
- foreground: oklch(0.985...)
- primary: oklch(0.7...)

## Animations

- Framer Motion for transitions
- Stagger effects for lists
- Loading skeletons

## Accessibility

- Radix UI primitives (ARIA support)
- Focus states
- Screen reader compatible