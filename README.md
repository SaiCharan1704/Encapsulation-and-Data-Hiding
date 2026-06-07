# Encapsulation and Data Hiding in Java

This component illustrates how to safeguard class internals using native access modifiers (`private`) 
alongside public structural methods (`getters`/`setters`) to achieve rigorous **Data Hiding** and business logic constraint safety.

## 🔒 Key Design Pillars Demonstrated

1. **Restricted Direct Access:** The `balance` and `accountNumber` attributes are explicitly marked `private`.
    This blocks external components or unauthorized classes from arbitrary structural alterations.
3. **Access Control via Methods:** Explicit read actions travel through `getAccountNumber()` and `getBalance()`.
   Alterations to the internal state are exclusively funneled through validated control pipelines (`setBalance`, `deposit`, `withdraw`).
5. **State Integrity Invariants:** Business rules (such as blocking negative monetary values) are declared inside mutable routes,
   ensuring that an object state can never fall into an invalid structural state.
