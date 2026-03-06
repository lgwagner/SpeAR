# SpeAR Modernization Execution Plan

This document is an execution-ready playbook for coding agents to modernize SpeAR to current Eclipse, Java, Xtext, JKind, and Z3 versions with controlled risk.

## 1) Objective and constraints

### Objective
Upgrade the build/runtime stack while preserving SpeAR analysis semantics (consistency, realizability, entailment) and shipping reproducible CI builds.

### Current-state anchors (from repository)
- Java source/target is `1.8` in parent Maven properties.
- Eclipse target platform is pinned to `2019-09` and old Orbit/JUnit artifacts.
- Xtext versions are inconsistent (`2.18.0` in parent, `2.19.0` in target/CLI dependency).
- Tycho is pinned to `1.7.0`.
- JKind/Z3 plugin repositories are local `file://home/...` paths.
- OSGi manifest ranges constrain JKind/Z3 and bundles require `JavaSE-1.8`.

### Non-goals
- No language feature additions in SpeAR syntax during this modernization.
- No UI redesign outside changes required by dependency/API migrations.

---

## 2) Target outcomes

- Build and tests pass with a modern Java LTS (preferred: 21, fallback: 17).
- Eclipse target platform moved from 2019-09 to a current release train.
- Xtext/EMF/MWE stack is version-aligned and regenerated artifacts are committed.
- JKind/Z3 pulled from stable hosted repositories (no developer-local paths).
- Regression suite demonstrates no unacceptable semantic drift.

---

## 3) Execution model for agents

### Branching and PR policy
- Create one umbrella branch: `upgrade/modernize-stack`.
- Submit *incremental* PRs in the exact phase order below.
- Each PR must include:
  - what changed
  - compatibility notes
  - risk/rollback notes
  - test evidence

### Global acceptance gates (all phases)
1. `mvn -f com.rockwellcollins.spear.parent/pom.xml clean verify` succeeds (or documented known issue with mitigation).
2. No unresolved local filesystem repositories in POM/target files.
3. No unresolved OSGi bundles at runtime product startup.
4. Baseline analysis scenarios still produce expected classifications unless explicitly approved.

---

## 4) Phase plan (do in order)

## Phase 0 — Baseline + CI scaffolding (mandatory first)

### Tasks
1. Add/refresh CI job for current branch baseline build.
2. Add parallel CI job for upgrade branch with selectable Java toolchain.
3. Record baseline outputs for representative test corpus:
   - consistency
   - realizability
   - entailment

### Deliverables
- `docs/upgrade-baseline.md` with command outputs and environment info.
- CI config updates showing baseline + candidate matrix.

### Exit criteria
- Baseline captured and reproducible.

---

## Phase 1 — Java LTS migration (without Eclipse train jump yet)

### Tasks
1. Raise Java compiler level in parent Maven properties.
2. Update all `Bundle-RequiredExecutionEnvironment` entries from `JavaSE-1.8` to target LTS.
3. Remove/simplify legacy JDK9 workaround properties if obsolete.
4. Fix compilation warnings/errors caused by stricter JDK.

### Deliverables
- Updated parent and plugin manifests.
- Migration notes documenting any source-level code edits needed.

### Exit criteria
- Full Maven/Tycho build passes on selected Java LTS with current target platform.

### Risks to watch
- Illegal reflective access / module boundary issues.
- Removed JDK classes/APIs.

---

## Phase 2 — Tycho + Eclipse target platform modernization

### Tasks
1. Upgrade Tycho to modern supported version.
2. Move `.target` repositories from `2019-09` (and matching Orbit) to current release train.
3. Replace obsolete pinned IUs with equivalents from current train.
4. Resolve p2 IU renames/removals.

### Deliverables
- Updated Tycho versions in parent POM.
- Updated `.target` file with modern repositories and resolvable units.

### Exit criteria
- Target platform resolves in CI without local mirrors.
- Build and plugin tests pass under new train.

### Risks to watch
- p2 resolution breakage from removed features.
- PDE metadata strictness changes.

---

## Phase 3 — Xtext/EMF/MWE alignment + regeneration

### Tasks
1. Choose one Xtext release and align all references (parent, target, module poms).
2. Align EMF/MWE dependencies to compatible versions.
3. Re-run MWE2/Xtext generation and commit generated code changes.
4. Fix compile/runtime API breakages in UI, scoping, validation, formatting layers.

### Deliverables
- Single-source-of-truth version properties for Xtext/EMF.
- Regenerated `src-gen/xtend-gen` artifacts as required.
- Changelog entry summarizing API adaptation edits.

### Exit criteria
- Editor loads and validates sample `.spear` files.
- Tests for parser/validation/IDE pass.

### Risks to watch
- Large generated diffs hiding manual logic regressions.
- Deprecated/removed Xtext extension points.

---

## Phase 4 — JKind + Z3 upgrade and repository hardening

### Tasks
1. Replace local `file://home/...` JKind/Z3 repositories with hosted/stable sources.
2. Upgrade CLI `jkind` dependency and plugin-side JKind API constraints.
3. Update Z3 plugin version range and verify native solver availability across OSes.
4. Re-check preference wiring and solver option mapping.

### Deliverables
- POM/manifest dependency updates for JKind/Z3.
- Setup notes for obtaining solver binaries in CI and product runtime.

### Exit criteria
- Realizability/consistency/entailment analyses run end-to-end from UI and CLI.
- No hardcoded local paths remain.

### Risks to watch
- Behavior drift from solver heuristic/version changes.
- Platform-specific native binary loading failures.

---

## Phase 5 — Semantic regression and release hardening

### Tasks
1. Run baseline-vs-upgrade corpus comparisons.
2. Classify diffs: expected, suspicious, blocker.
3. Add guardrail tests for previously fixed issues.
4. Produce release notes and rollback instructions.

### Deliverables
- `docs/upgrade-regression-report.md` with before/after tables.
- Final release checklist and known issues list.

### Exit criteria
- Approved semantic-diff report.
- All blocking regressions closed.

---

## 5) Agent task templates (copy/paste)

## Template A: “Do one phase”

> Execute **Phase N** from `docs/modernization-plan.md`.  
> Requirements: keep changes scoped to this phase, run full relevant tests, and produce:
> 1) code changes, 2) migration notes, 3) risk/rollback notes, 4) evidence (commands + outputs).  
> If blocked by dependency incompatibility, stop and open a blocker report with minimal repro.

## Template B: “Resolve blockers”

> Address blocker `<ID>` from the current phase.  
> Provide root-cause analysis, two fix options with trade-offs, apply preferred fix, and rerun phase exit checks.

## Template C: “Regression triage”

> Compare baseline and upgraded analysis outputs for corpus `<path>`.  
> Label each diff as `expected`, `needs-review`, or `blocker`, include rationale, and propose follow-up actions.

---

## 6) Definition of done

Modernization is complete only when:
- Java LTS, current Eclipse train, modern Tycho, aligned Xtext stack, and updated JKind/Z3 are all merged.
- Builds are reproducible in CI without local path repositories.
- Regression report is approved by maintainers.
- Release notes include migration/rollback guidance.

